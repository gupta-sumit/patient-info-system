package com.am.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.domain.ResourceAccessConfig;
import com.am.domain.Permission;
import com.am.domain.SharingInfo;
import com.am.repositories.ResourceAccessConfigRepository;
import com.am.services.AccessManagementService;
import com.am.services.DocumentAccessNotConfiguredException;

@Service
public class AccessManagementServiceImpl implements AccessManagementService {

	@Autowired
	private ResourceAccessConfigRepository documentAccessRepository;

	@Override
	public ResourceAccessConfig configureAccess(ResourceAccessConfig documentPermission) {
		return documentAccessRepository.save(documentPermission);
	}

	@Override
	public Optional<ResourceAccessConfig> getDocumentAccessConfig(String accessTokenId) {
		return documentAccessRepository.findById(accessTokenId);
	}

	@Override
	public void addUser(String resourceId, String userId, Permission permission) {
		Optional<ResourceAccessConfig> documentAccessConfigOpt = documentAccessRepository.findById(resourceId);
		if(documentAccessConfigOpt.isPresent()) {
			ResourceAccessConfig documentAccessConfig = documentAccessConfigOpt.get();
			if(CollectionUtils.isEmpty(documentAccessConfig.getSharedWith())) {
				List<SharingInfo> sharingInfoList = new ArrayList<>();
				sharingInfoList.add(SharingInfo.from(userId, permission));
				documentAccessConfig.setSharedWith(new HashSet<>(sharingInfoList));
			} else {
				Optional<SharingInfo> sharingInfoOpt = documentAccessConfig.getSharedWith().stream().filter(s -> s.getUserId().equals(userId)).findFirst();
				if(sharingInfoOpt.isPresent()) {
					sharingInfoOpt.get().setGrantedPermission(permission);
					sharingInfoOpt.get().setGrantedDate(new Date());
				} else {
					documentAccessConfig.getSharedWith().add(SharingInfo.from(userId,permission));
				}
			}
			documentAccessRepository.save(documentAccessConfig);
		} else {
			throw new DocumentAccessNotConfiguredException();
		}
		
	}

	@Override
	public void removeUser(String resourceId, String userId) {
		Optional<ResourceAccessConfig> documentAccessConfigOpt = documentAccessRepository.findById(resourceId);
		if(documentAccessConfigOpt.isPresent()) {
			ResourceAccessConfig documentAccessConfig = documentAccessConfigOpt.get();
			if(CollectionUtils.isEmpty(documentAccessConfig.getSharedWith())) {
				return;
			} else {
				boolean remove = documentAccessConfig.getSharedWith().remove(SharingInfo.from(userId, null));
				if(remove) {
					documentAccessRepository.save(documentAccessConfig);
				}
			}
			return;
		}
		throw new DocumentAccessNotConfiguredException();
	}

	@Override
	public SharingInfo getSharingInfoForUser(String resourceId, String userId) {
		Optional<ResourceAccessConfig> documentAccessConfigOpt = documentAccessRepository.findById(resourceId);
		if(documentAccessConfigOpt.isPresent()) {
			ResourceAccessConfig documentAccessConfig = documentAccessConfigOpt.get();
			// Owner is access record. So grant him full access
			if(documentAccessConfig.getOwnerInfo().getUserId().equals(userId)) {
				return SharingInfo.from(userId, Permission.ALL);
			}
			Optional<SharingInfo> sharingInfoOpt = documentAccessConfig.getSharedWith().stream().filter(s -> s.getUserId().equals(userId)).findFirst();
			if(sharingInfoOpt.isPresent()) {
				return sharingInfoOpt.get();
			}
		} 
		return null;
	}
	
	
}
