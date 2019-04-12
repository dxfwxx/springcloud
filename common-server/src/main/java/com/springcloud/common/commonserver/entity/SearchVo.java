package com.springcloud.common.commonserver.entity;

import lombok.Data;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class SearchVo {
	
	private String id;
	
	private String userId;
	
	private String blogId;
	
	private String order;
	
	private String tags;
	
	private Integer pageNum;
	
	private Integer pageSize;
}
