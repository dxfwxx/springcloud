package com.springcloud.cn.serviceblog.controller;

import com.springcloud.cn.serviceblog.entity.Comment;
import com.springcloud.cn.serviceblog.service.CommentService;
import com.springcloud.common.commonserver.entity.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/addComment")
	@ResponseBody
	public MessageBody addComment(@RequestBody Comment comment) throws Exception {
		return MessageBody.getMessageBody(true, commentService.addComment(comment));
	}
}
