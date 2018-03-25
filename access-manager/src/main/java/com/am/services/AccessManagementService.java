package com.am.services;

import java.util.Optional;

import com.am.domain.ResourceAccessConfig;
import com.am.domain.Permission;
import com.am.domain.SharingInfo;

public interface AccessManagementService {

	public ResourceAccessConfig configureAccess(ResourceAccessConfig documentPermission);

	public Optional<ResourceAccessConfig> getDocumentAccessConfig(String accessTokenId);
	
	public void addUser(String accessTokenId,String userId, Permission permission);
	
	public void removeUser(String accessTokenId, String userId);
	
	public SharingInfo getSharingInfoForUser(String accessToken, String userId);
	
	
}
