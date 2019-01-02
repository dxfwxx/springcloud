package com.springcloud.cn.serviceblog.dao;

import com.springcloud.cn.serviceblog.entity.Blog;
import com.springcloud.common.commonserver.entity.SearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Mapper
public interface BlogDao {
	
	List<Blog> findBlogForPage(SearchVo searchVo);
}
