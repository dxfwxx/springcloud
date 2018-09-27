package com.springcloud.cn.servicefeign.service.impl;

import com.springcloud.cn.servicefeign.service.ScheduleServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {
	@Override
	public String sayHiFromClientOne(String name) {
		return "hi, " + name + "  sorry, rest error";
	}
}
