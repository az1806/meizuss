package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.NewsTypeDao;
import com.jiajiu.dao.impl.NewsTypeDaoImpl;

public class HouTai_DelNewsTypeServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		doPost(request,response);
		
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		int typeid=Integer.parseInt(request.getParameter("typeid"))  ;
		NewsTypeDao newsdao=new NewsTypeDaoImpl();	
	 boolean  newstype=	newsdao.delNewsType(typeid);
		
	 if(newstype==true){
			System.out.println("������ѱ�ɾ��,�������������ô�������ӷ�����������������ӻ���Ŷ.");
		}else{
			System.out.println("������һ��������Ŷ����Ҫ���ټ������룬���ܰ���ɾ��Ŷ");
			
		}
		request.getRequestDispatcher("tgls/newsManage/newsType.jsp").forward(request, response);
		
	}

}
