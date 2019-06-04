package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.ProductlistDao;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiajiu.dao.impl.ProductlistDaoImpl;
import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;

public class Productdetails extends HttpServlet {

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
		 ProductClassDao pcd=new ProductClassDaoImpl();		
		   List<ProductClass> pts=pcd.queryProductClass();
		
		  
		   int typeid;
		  
		   
		   if(request.getParameter("typeid")==null){
			   typeid=pts.get(0).getTypeid();
			   
		   }else{
			   typeid=Integer.parseInt(request.getParameter("typeid"));
			   
		   }
		
		   
		/**
		 * 有参进行切换
		 */
       ProductlistDao productdao=new ProductlistDaoImpl();
      List<Product> plist=productdao.queryProduct(typeid);
      
      
      /**
       * 无参显示产品详情
       */
      ProductlistDao productdaowucan=new ProductlistDaoImpl();
      List<Product> plistwucan=productdaowucan.queryProductwucan();
      
      request.setAttribute("plistwucan",plistwucan);
      
      request.setAttribute("plist",plist);
		 request.setAttribute("productclass",pts);
		request.getRequestDispatcher("productdetails.jsp").forward(request, response);
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
