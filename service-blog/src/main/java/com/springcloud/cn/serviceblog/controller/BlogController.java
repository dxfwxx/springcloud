package com.springcloud.cn.serviceblog.controller;

import com.springcloud.cn.serviceblog.entity.Blog;
import com.springcloud.cn.serviceblog.utils.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Controller
public class BlogController {
	
	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@RequestMapping("/findBlogForPage")
	@ResponseBody
	public MessageBody findBlogForPage(@RequestBody Blog blog) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public MessageBody createBlog(@RequestBody Blog blog) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public MessageBody updateBlog(@RequestBody Blog blog) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public MessageBody deleteBlog(@RequestBody Blog blog) {
		return MessageBody.getMessageBody(true);
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public MessageBody findBlogById(@RequestBody Blog blog) {
		return MessageBody.getMessageBody(true);
	}
}
