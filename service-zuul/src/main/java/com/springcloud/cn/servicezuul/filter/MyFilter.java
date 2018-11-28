package com.springcloud.cn.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.cn.servicezuul.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Component
public class MyFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Autowired
	private RedisUtil redisUtil;

	// 前置过滤器
	@Override
	public String filterType() {
		return "pre";
	}

	// 执行顺序
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		String url = request.getRequestURL().toString();
		//获取认证名称
		String authName =request.getHeader("Authorization");
		String token=null;
		logger.info("authName: " + authName);
		logger.info("user: " + request.getUserPrincipal());

//
//		if(StringUtils.isNotBlank(authName)) {
//			//用户请求时会在头部 Authorization 传给我之前存储的token, 我用来验证
//			authName= "access:" + authName.replace("Bearer ","");
//			//获取redis存储的token
//			if (redisUtil.exists(authName)){
//				//查询redis是否有token
//				token= (String) redisUtil.get(authName);
//			}
//		}
//
//		//此处判断是否要拦截**************
//		//过滤登录方法
//		if(url.contains("/login") || url.contains("/uaa") || url.contains("/index")){
//			return null;
//		}
//		logger.info(String.format("%s  拦截的url: %s",request.getMethod(),url));
//
//
//		//没有加认证token 就没有访问权限
//		if(StringUtils.isBlank(authName)) {
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(401);
//			requestContext.setResponseBody("{\"code\":401,\"msg\":\"没有访问权限！\"}");
//			requestContext.getResponse().setContentType("text/html;charset=UTF-8");
//		}else if(token == null){
//			//token失效了
//			//用户提供的token检测出和redis不一样
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(401);
//			requestContext.setResponseBody("{\"code\":401,\"msg\":\"令牌失效,请重新登录！\"}");
//			requestContext.getResponse().setContentType("text/html;charset=UTF-8");
//		}
		return null;

	}
}
