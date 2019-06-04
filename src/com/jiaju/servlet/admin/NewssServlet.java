package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.NewsDao;
import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiaju.entity.News;

public class NewssServlet extends BaseServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	
	
	
	
	
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		NewsDao newsdao=new NewsDaoImpl();
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		String title = java.net.URLDecoder.decode(request.getParameter("title"), "utf-8");
		String content = java.net.URLDecoder.decode(request.getParameter("content"), "utf-8");
		String time=request.getParameter("time");
		int n=newsdao.addNews(typeid, title, content, time);
		if(n>0){
			List<News> newslist=newsdao.queryNewsDaowucan();
		request.setAttribute("newslist",newslist);
		request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
			
			
			
			
		}
		
		
		
	}
	
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsDao newsdao=new NewsDaoImpl();
		
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		
		int n=newsdao.delNews(newsid);
		
		if(n>0){
			List<News> newslist=newsdao.queryNewsDaowucan();
			request.setAttribute("newslist",newslist);
			request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsDao newsdao=new NewsDaoImpl();
		List<News> newslist=newsdao.queryNewsDaowucan();
		request.setAttribute("newslist",newslist);
		request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
	}

}
