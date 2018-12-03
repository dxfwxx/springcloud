package com.springcloud.cn.serviceuser.controller;

import com.springcloud.cn.serviceuser.entity.SysUser;
import com.springcloud.cn.serviceuser.entity.User;
import com.springcloud.cn.serviceuser.service.UserService;
import com.springcloud.cn.serviceuser.utils.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public MessageBody login(@RequestBody User user) {
		return MessageBody.getMessageBody(true);
	}
	@RequestMapping("/register")
	@ResponseBody
	public MessageBody register(@RequestBody User user) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public MessageBody updateUser(@RequestBody User user) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/findUser")
	@ResponseBody
	public MessageBody findUserById(@RequestBody User user) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/loadUserByUsername")
	@ResponseBody
	public SysUser loadUserByUsername(@RequestBody String username) { return userService.loadUserByUsername(username); }
}
