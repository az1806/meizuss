package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.CompanyDao;
import com.jiajiu.dao.impl.CompanyDaoImpl;
import com.jiaju.entity.Company;

public class CompanyAdminServlet extends BaseServlet {

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
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  System.out.println("已到达修改公司信息的servlet");
  int id= Integer.parseInt(request.getParameter("id"));
		String companyname = java.net.URLDecoder.decode(request.getParameter("companyname"), "utf-8");
		String syjs = java.net.URLDecoder.decode(request.getParameter("syjs"), "utf-8");
		String gyjs = java.net.URLDecoder.decode(request.getParameter("gyjs"), "utf-8");
		String culture = java.net.URLDecoder.decode(request.getParameter("culture"), "utf-8");
		String address = java.net.URLDecoder.decode(request.getParameter("address"), "utf-8");
		String email = java.net.URLDecoder.decode(request.getParameter("email"), "utf-8");
		String contact = java.net.URLDecoder.decode(request.getParameter("contact"), "utf-8");
		String imgzong = java.net.URLDecoder.decode(request.getParameter("imgzong"), "utf-8");
		String www = java.net.URLDecoder.decode(request.getParameter("www"), "utf-8");
		
		CompanyDao comdao=new CompanyDaoImpl();
		int n=comdao.updateCompany(id, companyname, syjs, gyjs, culture, address, email, contact, imgzong, www);
		if(n>0){
		  System.out.println("公司信息修改成功");
			Company com=comdao.queryCompany();
			request.setAttribute("com",com);
			request.getRequestDispatcher("tgls/companyManage/companylist.jsp").forward(request, response);
		}else{
			
			System.out.println("修改失败");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
