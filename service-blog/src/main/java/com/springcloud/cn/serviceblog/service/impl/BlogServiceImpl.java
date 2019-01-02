package com.springcloud.cn.serviceblog.service.impl;

import com.springcloud.cn.serviceblog.dao.BlogDao;
import com.springcloud.cn.serviceblog.entity.Blog;
import com.springcloud.cn.serviceblog.service.BlogService;
import com.springcloud.common.commonserver.entity.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Override
	public List<Blog> findBlogForPage(SearchVo searchVo) {
		return blogDao.findBlogForPage(searchVo);
	}
}
