package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.NewsTypeDao;
import com.jiajiu.dao.impl.NewsTypeDaoImpl;
import com.jiaju.entity.NewsType;
import com.jiaju.util.Result;

public class NewsTypeServlet extends BaseServlet {

	
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();	
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		boolean judge=newstypedao.delNewsType(typeid);
		if(judge){
			
			
			List<NewsType> newstype=newstypedao.queryNewsTypes();
			request.setAttribute("hnewstype", newstype);
			request.getRequestDispatcher("tgls/newsManage/newsType.jsp").forward(request, response);
			
			
			
		}else{
			
			out.println(Result.toClient(false, "就凭你还想把我删掉"));
			
		}
	}

	
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		
		
		String typename=request.getParameter("typename");
		
         boolean judge=newstypedao.addNewsType(typename);
         
         if(judge){	 
        	 List<NewsType> newstype=newstypedao.queryNewsTypes();
 			request.setAttribute("hnewstype", newstype);
 			request.getRequestDispatcher("tgls/newsManage/newsType.jsp").forward(request, response);
 
         }else{
        	 out.println(Result.toClient(false, "再等下，我还没到"));
         }
            	  
            	
	}

}
