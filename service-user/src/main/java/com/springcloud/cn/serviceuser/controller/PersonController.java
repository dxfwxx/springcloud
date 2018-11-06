package com.springcloud.cn.serviceuser.controller;

import com.springcloud.cn.serviceuser.entity.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
public class PersonController {
	
	@GetMapping("/person")
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public @ResponseBody Person personInfo() {
		return new Person("peter", "Beijing", "China", 29, "Male");
	}
}