package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.MemberDao;
import com.jiajiu.dao.impl.MemberDaoImpl;

public class HouTai_AddMembersServlet extends HttpServlet {

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
    
		MemberDao memdao=new MemberDaoImpl();
		Integer id=null;
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String position=request.getParameter("position");
		String photo=request.getParameter("photo");
		
	boolean member=	memdao.AddMember(id, name, position, photo);
	if(member==true){
		System.out.println("成员加入成功");
	}else{
		System.out.println("成员加入成功");
	}
	
		
		
		
		
		
	}

}
