package com.example.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 过滤器
 * @author yaoyuzhao
 *
 */
@Component
public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		System.out.println("send "+request.getMethod()+"  request to "+request.getRequestURI().toString());
		Object token = request.getParameter("accessToken");
		if(token == null) {
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
