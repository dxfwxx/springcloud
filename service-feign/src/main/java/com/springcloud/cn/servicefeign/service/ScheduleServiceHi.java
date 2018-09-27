package com.springcloud.cn.servicefeign.service;

import com.springcloud.cn.servicefeign.service.impl.ScheduleServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@FeignClient(value = "service-hi", fallback = ScheduleServiceHiHystrix.class)
@Service
public interface ScheduleServiceHi {
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
	
}
