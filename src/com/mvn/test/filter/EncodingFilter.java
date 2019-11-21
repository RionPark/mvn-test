package com.mvn.test.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String charSet = "utf-8"; 
	List<String> excludePatterns = new ArrayList<>();
    public EncodingFilter() {
    	excludePatterns.add(".js");
    	excludePatterns.add(".css");
    	excludePatterns.add(".html");
    	excludePatterns.add(".htm");
    }

    public boolean isExclude(String path) {
    	for(String pat: excludePatterns) {
    		if(path.indexOf(pat)!=-1) {
    			return true;
    		}
    	}
    	return false;
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(this.charSet); 
		HttpServletResponse res = (HttpServletResponse)response;
		String path = req.getRequestURI();
		if(!isExclude(path)) {
			res.setContentType("application/json;charset=" + this.charSet);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String charSet = fConfig.getInitParameter("charSet");
		if(charSet!=null) {
			this.charSet = charSet;
		}
	}

	@Override
	public void destroy() {
	}
}
