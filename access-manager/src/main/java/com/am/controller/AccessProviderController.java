package com.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.am.domain.AccessRequest;
import com.am.dto.AccessRequestDTO;
import com.am.dto.RequestStatusUpdate;
import com.am.services.AccessProviderService;

@RestController
@RequestMapping("/ap")
public class AccessProviderController {

	@Autowired
	private AccessProviderService accessProviderService;
	
	@PostMapping("/request-access")
	public AccessRequest requestAccess(@RequestBody AccessRequestDTO accessRequestDTO) {
		return accessProviderService.requestAccess(accessRequestDTO.getResourceId(), accessRequestDTO.getUserId(), accessRequestDTO.getPermission());
		//return new AccessResponseDTO(requestAccess.getRequestId());
	}
	
	@PostMapping("/update-request")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateRequestStatus(@RequestBody RequestStatusUpdate update) throws IllegalAccessException {
		accessProviderService.updateRequestStatus(update.getRequestId(), update.getUserId(), update.getRequestStatus());
	}
	
	@DeleteMapping("/{accessTokenId}/{userId}/{toBeRemovedUserId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void revokePermission(@PathVariable("accessTokenId") String accessTokenId,
			@PathVariable("userId") String userId,
			@PathVariable("toBeRemovedUserId") String toBeRemovedUserId) throws IllegalAccessException {
		accessProviderService.revokeAccess(accessTokenId, userId, toBeRemovedUserId);
	}
}
