package com.springcloud.cn.serviceblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class Blog implements Serializable {
	
	private String id;
	
	private String title;
	
	private String summary;
	
	private Integer readSize;
	
	private String content;
	
	private Integer commentSize;
	
	private Date createTime;
	
	private String authorId;
	
	private String authorName;
	
	private String tags;
	
	private String catalogId;
	
	private List<Comment> commentList;
}
