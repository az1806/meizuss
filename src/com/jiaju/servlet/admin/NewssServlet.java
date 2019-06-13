package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiajiu.dao.NewsDao;
import com.jiajiu.dao.NewsTypeDao;

import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiajiu.dao.impl.NewsTypeDaoImpl;

import com.jiaju.entity.News;
import com.jiaju.entity.NewsType;


public class NewssServlet extends BaseServlet {
	
	/**
	 * ������������
	 */
	
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * ���ŷ���
		 */
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		List<NewsType> newstype=newstypedao.queryNewsTypes();
		request.setAttribute("newstype", newstype);
	
		
		
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		
		
		String title = request.getParameter("title");
		
		
		String content =request.getParameter("content");
		
		
		NewsDao newsdao=new NewsDaoImpl();
		
		List<News> searchnews=newsdao.conditionquery(typeid, title, content);
		
		
		request.setAttribute("searchnews",searchnews);
		request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
		
		
		
	}
	
	/**
	 * ����id�޸�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
      NewsDao newsdao=new NewsDaoImpl();
      PrintWriter out=response.getWriter();
      Integer newsid=Integer.parseInt(request.getParameter("newsid"));
      Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		String title=request.getParameter("title");
		
		String content=request.getParameter("content");
		String time=request.getParameter("time");
		int n=newsdao.updateNewsById(newsid, typeid, title, content, time);
		if(n>0){
		
			System.out.println("�����޸ĳɹ����ֵ�");
			out.println("<script>window.parent.location.reload()</script>");
			
		}else{
			
			System.out.println("�����޸�ʧ������û���ֵ�");
		}
		
		
		
	}
	
	
	/**
	 * ����id��ʾ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void zhezhao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
      NewsDao newsdao=new NewsDaoImpl();
      Integer newsid=Integer.parseInt(request.getParameter("newsid"));
      
      News news=newsdao.queryNewsByID(newsid);
      
      request.setAttribute("news", news);
	 if(news!=null){
		 
	
		 
		 System.out.println("������ʾ�ɹ������ֵ�");
		 request.getRequestDispatcher("tgls/newsManage/news_update.jsp").forward(request, response);
		 
	 }else{
		 
		 System.out.println("������ʾʧ�ܣ�û�¼��ͣ��ֵ�");
	 }
		
		
		
		
	}
	
	
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
//			NewsTypeDao newstypedao=new NewsTypeDaoImpl();
//			List<NewsType> newstype=newstypedao.queryNewsTypes();
//			request.setAttribute("newstype", newstype);
//		
//			
//			List<News> newslist=newsdao.queryNewsDaowucan();
//		request.setAttribute("newslist",newslist);
//		request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
		
			out.print("<script>alert('���ӳɹ�');"+"window.location.href=document.referrer;</script>");
			
		}
		
		
		
	}
	
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		List<NewsType> newstype=newstypedao.queryNewsTypes();
		request.setAttribute("newstype", newstype);
	

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		NewsDao newsdao=new NewsDaoImpl();
		
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		
		int n=newsdao.delNews(newsid);
		
		if(n>0){
			out.print("<script>window.location.href=document.referrer  </script>");
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
		
		HttpSession session=request.getSession();
		
		NewsTypeDao newstypedao=new NewsTypeDaoImpl();
		List<NewsType> newstype=newstypedao.queryNewsTypes();
		request.setAttribute("newstype", newstype);
		
		
			request.getRequestDispatcher("tgls/newsManage/new_list.jsp").forward(request, response);
		
	}

}
