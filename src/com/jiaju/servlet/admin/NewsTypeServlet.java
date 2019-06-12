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

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      PrintWriter out=response.getWriter();
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		String typename=request.getParameter("typename");
		int n=newstypedao.updateNewsType(typeid, typename);
		if(n>0){
			
			System.out.println("新闻类别修改成功了兄弟");
			out.println("<script>window.parent.location.reload()</script>");
		
		}  else{
			
			
			System.out.println("新闻类别修改失败了兄弟");
		}
		
		
		
		 out.flush();
	 		out.close();	
	
	}
	
	
	
	
	public void zhezhao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		NewsType newstype=newstypedao.queryNewsTypeByID(typeid);
		request.setAttribute("newstype", newstype);
		request.getRequestDispatcher("tgls/newsManage/newsType_update.jsp").forward(request, response);
	
	}
	
	/**
	 * 删除新闻类别根据typeid
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		  Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		
      int judge=newstypedao.delNewsType(typeid);	
	        
		
			if(judge>0){
//				 List<NewsType> newstype=newstypedao.queryNewsTypes();
//		 			request.setAttribute("hnewstype", newstype);
//		 			request.getRequestDispatcher("tgls/newsManage/newsType.jsp").forward(request, response);
		
			
				//返回到上个界面并刷新
				out.print("<script>window.location.href=document.referrer;</script>");		
					}		
	  	out.flush();
		out.close();
      	}

	/**
	 * 增加一个新闻类别
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		
		
		String typename=request.getParameter("typename");
		
      int judge=newstypedao.addNewsType(typename);
         
         if(judge>0){	 
//        	 List<NewsType> newstype=newstypedao.queryNewsTypes();
// 			request.setAttribute("hnewstype", newstype);
// 			request.getRequestDispatcher("tgls/newsManage/newsType.jsp").forward(request, response);
 
        		out.print("<script>alert('增加成功');"+"window.location.href=document.referrer;</script>");
         }
            	  
         out.flush();
 		out.close();	
	}

}
