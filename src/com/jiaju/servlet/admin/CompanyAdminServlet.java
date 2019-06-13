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
		String companyname = request.getParameter("companyname");
		String syjs = request.getParameter("syjs");
		String gyjs = request.getParameter("gyjs");
		String culture = request.getParameter("culture");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String imgzong = request.getParameter("imgzong");
		String www = request.getParameter("www");
		String logo = request.getParameter("logo");
		CompanyDao comdao=new CompanyDaoImpl();
		int n=comdao.updateCompany(id, companyname, syjs, gyjs, culture, address, email, contact, imgzong, www,logo);
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
