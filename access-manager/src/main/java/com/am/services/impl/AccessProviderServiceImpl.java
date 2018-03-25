package com.am.services.impl;

import com.am.domain.AccessRequest.RequestStatus;
import com.am.domain.ResourceAccessConfig;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.domain.AccessRequest;
import com.am.domain.Permission;
import com.am.repositories.AccessRequestRepository;
import com.am.services.AccessManagementService;
import com.am.services.AccessProviderService;
import com.am.services.DocumentAccessNotConfiguredException;
import com.am.services.RequestNotFoundException;

@Service
public class AccessProviderServiceImpl implements AccessProviderService {

	@Autowired
	private AccessManagementService accessManagementService;
	
	@Autowired
	private AccessRequestRepository accessRequestRepository;
	
	@Override
	public AccessRequest requestAccess(String accessToken, String userId, Permission permission) {
		Optional<ResourceAccessConfig> documentAccessConfiOpt = accessManagementService.getDocumentAccessConfig(accessToken);
		if(!documentAccessConfiOpt.isPresent()) {
			throw new DocumentAccessNotConfiguredException("No document configured for access token " + accessToken);
		}
		ResourceAccessConfig documentAccessConfig = documentAccessConfiOpt.get();
		AccessRequest accessRequest = new AccessRequest();
		accessRequest.setAccessTokenId(accessToken);
		accessRequest.setRequestedDate(new Date());
		accessRequest.setRequestStatus(RequestStatus.PENDING);
		accessRequest.setApproverId(documentAccessConfig.getOwnerInfo().getUserId());
		accessRequest.setRequestedUserId(userId);
		accessRequest.setRequestedPermission(permission);
		return accessRequestRepository.save(accessRequest);
		// Send notification to users
	}

	@Override
	public void updateRequestStatus(String requestId, String userId, RequestStatus requestStatus) throws IllegalAccessException {
		Optional<AccessRequest> accessRequestOpt = accessRequestRepository.findById(requestId);
		if(accessRequestOpt.isPresent()) {
			if(!RequestStatus.PENDING.equals(accessRequestOpt.get().getRequestStatus())) {
				throw new RequestAlreadyClosedException("Request already closed. Open new request. Request Id " + requestId);
			}
			AccessRequest accessRequest = accessRequestOpt.get();
			String accessTokenId = accessRequest.getAccessTokenId();
			Optional<ResourceAccessConfig> documentAccessConfigOpt = accessManagementService.getDocumentAccessConfig(accessTokenId);
			if(documentAccessConfigOpt.isPresent()) {
				ResourceAccessConfig documentAccessConfig = documentAccessConfigOpt.get();
				if(documentAccessConfig.getOwnerInfo().getUserId().equals(userId)) {
					if(RequestStatus.APPROVED.equals(requestStatus)) {
						// Check approver is owner or not
						accessManagementService.addUser(accessTokenId, accessRequest.getRequestedUserId(), accessRequest.getRequestedPermission());
						accessRequest.setRequestStatus(requestStatus);
					} else if(RequestStatus.REJECTED.equals(requestStatus)){
						accessRequest.setRequestStatus(requestStatus);
					}
					accessRequest.setLastUpdatedDate(new Date());
					accessRequestRepository.save(accessRequest);
				} else {
					throw new IllegalAccessException("User " + userId + " is not owner of resource " + accessTokenId);
				}
				
			}
		} else {
			throw new RequestNotFoundException("Request not found by request id " + requestId);
		}
	}

	@Override
	public void revokeAccess(String resourceId, String authUser, String userToBeRemoved) throws IllegalAccessException {
			Optional<ResourceAccessConfig> documentAccessConfigOpt = accessManagementService.getDocumentAccessConfig(resourceId);
			if(documentAccessConfigOpt.isPresent()) {
				ResourceAccessConfig documentAccessConfig = documentAccessConfigOpt.get();
				if(documentAccessConfig.getOwnerInfo().getUserId().equals(authUser)) {
					accessManagementService.removeUser(resourceId, userToBeRemoved);
				} else {
					throw new IllegalAccessException("User " + authUser + " is not owner of resource " + resourceId);
				}
				
			} else {
				throw new DocumentAccessNotConfiguredException("Resource not configured for " + resourceId);
			}
	}

}
