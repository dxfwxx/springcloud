package com.springcloud.cn.serviceuser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
public class UserController {
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
