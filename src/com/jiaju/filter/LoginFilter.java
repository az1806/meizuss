package com.jiaju.filter;
import java.util.regex.*;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Request;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) res;
		HttpSession session=request.getSession();/**获取Session*/
		String path=request.getRequestURI();
	   	System.out.println(path);
		
          String	pattern =".*admi.*";
	     // 判断patter是否包含path  
          boolean isMatch = Pattern.matches(pattern, path);
	 
		 System.out.println("是否包含"+isMatch);
		if(session.getAttribute("name")!=null){
			chain.doFilter(request, response);//放行
			
			
		}else if(isMatch==false||path.equals("/jiaju/login")||path.equals("/jiaju/login.jsp")||path.endsWith(".css")||path.endsWith(".js")||path.endsWith(".jsp")||path.endsWith(".jpg")){
			chain.doFilter(request, response);//放行
		
		}
		else{
			response.sendRedirect("login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
