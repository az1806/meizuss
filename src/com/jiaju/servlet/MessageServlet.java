package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.MessageDao;
import com.jiajiu.dao.impl.MessageDaoImpl;
import com.jiaju.entity.Message;

public class MessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer lyid=null;
		String usernamez=request.getParameter("username");
		String phonez=request.getParameter("tel");
		String emailz=request.getParameter("email");
		String contentz=request.getParameter("content");
		PrintWriter out=response.getWriter();
		MessageDao msdo=new MessageDaoImpl();
	 boolean ly=msdo.insertMess(lyid, usernamez, phonez, emailz, contentz);
	 if(ly==true){
		 System.out.println("���Բ���ɹ�");
		 out.println("<script>  alert('���Գɹ�!');"+"location.herf='message.jsp'; </script>");
		 
		 
	 }else{
		 out.println("<script>  alert('����ʧ��!');"+"location.herf='message.jsp'; </script>");
		 
		 
	 }
	 
		System.out.println("���Լ���ɹ�");
		
		request.getRequestDispatcher("message.jsp").forward(request, response);
		
	}

}
