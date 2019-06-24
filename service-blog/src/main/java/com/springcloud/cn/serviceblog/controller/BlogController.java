package com.springcloud.cn.serviceblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.cn.serviceblog.entity.Blog;
import com.springcloud.cn.serviceblog.service.BlogService;
import com.springcloud.common.commonserver.entity.MessageBody;
import com.springcloud.common.commonserver.entity.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
@Slf4j
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/findBlogForPage")
	@ResponseBody
	public MessageBody findBlogForPage(@RequestBody SearchVo searchVo) {
		PageHelper.startPage(searchVo.getPageNum(), searchVo.getPageSize());
		
		List<Blog> blogList = blogService.findBlogForPage(searchVo);
		System.out.println(blogList);
		PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
		return MessageBody.getMessageBody(true, pageInfo);
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
	public MessageBody findBlogById(@RequestBody SearchVo searchVo) {
		return MessageBody.getMessageBody(true, blogService.findBlogById(searchVo));
	}
}
