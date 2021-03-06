package com.springcloud.cn.serviceuser.controller;

import com.springcloud.cn.serviceuser.entity.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
public class PersonController {
	
	@PostMapping ("/person")
//	@PreAuthorize("hasAnyAuthority('ADD')")
	@ResponseBody
	public Person personInfo(@RequestBody Person person) {
		return new Person("peter", "Beijing", "China", 29, "Male");
	}
}