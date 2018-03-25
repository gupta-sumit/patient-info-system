package com.am.services;

import com.am.domain.AccessRequest;
import com.am.domain.AccessRequest.RequestStatus;
import com.am.domain.Permission;

public interface AccessProviderService {

	public AccessRequest requestAccess(String accessToken, String userId, Permission permission);

	public void updateRequestStatus(String requestId, String userId, RequestStatus requestStatus) throws IllegalAccessException;

	public void revokeAccess(String resourceId, String authUser, String userToBeRemoved) throws IllegalAccessException;
}
