package com.springcloud.cn.serviceblog.entity;

import lombok.Data;
import java.util.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class Comment {
	
	private String id;
	
	private String userId;
	
	private String blogId;
	
	private String userName;
	
	private String blogComment;
	
	private Date createTime;
	
	private Date updateTime;
}
