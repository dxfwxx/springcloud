package com.springcloud.cn.serviceblog.service;

import com.springcloud.cn.serviceblog.entity.Comment;
import com.springcloud.common.commonserver.entity.SearchVo;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public interface CommentService {
	
	List<Comment> queryCommentByBlog(SearchVo searchVo);
	
	Comment addComment(Comment comment);
}
