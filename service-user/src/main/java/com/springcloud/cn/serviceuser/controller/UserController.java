package com.springcloud.cn.serviceuser.controller;

import com.springcloud.cn.serviceuser.entity.Person;
import com.springcloud.cn.serviceuser.entity.User;
import com.springcloud.cn.serviceuser.utils.MessageBody;
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
	
}
