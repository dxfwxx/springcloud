package com.springcloud.cn.serviceblog.service.impl;

import com.springcloud.cn.serviceblog.dao.CommentDao;
import com.springcloud.cn.serviceblog.entity.Comment;
import com.springcloud.cn.serviceblog.service.CommentService;
import com.springcloud.common.commonserver.entity.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	@Override
	public List<Comment> queryCommentByBlog(SearchVo searchVo) {
		return commentDao.queryCommentByBlog(searchVo);
	}
	
	@Override
	public Comment addComment(Comment comment) {
		comment.setBlogId("10");
		comment.setCreateTime(new Date());
		comment.setUserId("123");
		comment.setUserName("dxf");
		comment.setId(UUID.randomUUID().toString());
		commentDao.add(comment);
		return comment;
	}
}
