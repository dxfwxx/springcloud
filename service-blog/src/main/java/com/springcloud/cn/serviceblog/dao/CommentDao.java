package com.springcloud.cn.serviceblog.dao;

import com.springcloud.cn.serviceblog.entity.Comment;
import com.springcloud.common.commonserver.entity.SearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Mapper
public interface CommentDao {
	
	List<Comment> queryCommentByBlog(SearchVo searchVo);
	
	int add(Comment comment);
}
