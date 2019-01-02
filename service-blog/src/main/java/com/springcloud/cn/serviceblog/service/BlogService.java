package com.springcloud.cn.serviceblog.service;

import com.springcloud.cn.serviceblog.entity.Blog;
import com.springcloud.common.commonserver.entity.SearchVo;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public interface BlogService {
	
	List<Blog> findBlogForPage(SearchVo searchVo);
}
