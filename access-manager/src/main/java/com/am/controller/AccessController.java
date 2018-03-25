package com.am.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.am.domain.ResourceAccessConfig;
import com.am.domain.SharingInfo;
import com.am.domain.User;
import com.am.dto.ResourceAccessConfigDTO;
import com.am.services.AccessManagementService;

@RestController
@RequestMapping("/am")
public class AccessController {

	private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
	
	@Autowired
	private AccessManagementService accessManagementService;
	
	
	@PostMapping("/config")
	public ResourceAccessConfigDTO configureAccess(@RequestBody ResourceAccessConfigDTO accessConfigDTO) {
		// config call should be used by internal services only. not outside
		logger.info("Received request to config resource permission: {}", accessConfigDTO);
		ResourceAccessConfig accessConfig = new ResourceAccessConfig();
		accessConfig.setAppServiceName(accessConfigDTO.getAppServiceName());
		accessConfig.setCreatedDate(new Date());
		accessConfig.setDocumentId(accessConfigDTO.getDocumentId());
		accessConfig.setDocumentType(accessConfigDTO.getDocumentType());
		accessConfig.setOwnerInfo(new User(accessConfigDTO.getUserId()));
		ResourceAccessConfig savedAccessConfig = accessManagementService.configureAccess(accessConfig);
		accessConfigDTO.setResourceId(savedAccessConfig.getResourceId());
		return accessConfigDTO;
	}
	
	@GetMapping("/permission/{accessTokenId}/{userId}")
	public SharingInfo fetchPermission(@PathVariable("accessTokenId") String accessTokenId,@PathVariable("userId") String userId) {
		return accessManagementService.getSharingInfoForUser(accessTokenId, userId);
	}
	
	
	
	@GetMapping("/{userId}/user")
	public void fetchUserPermissions(String userId) {
		
	}
	
}
