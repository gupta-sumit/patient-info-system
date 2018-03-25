package com.ds.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.domain.UserPermission;

@FeignClient(name="access-manager")
public interface AccessManagerService {

	@RequestMapping(value="/am/permission/{accessKey}/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserPermission getUserPermission(@PathVariable("accessKey") String accessKey, @PathVariable("userId") String userId);
}
