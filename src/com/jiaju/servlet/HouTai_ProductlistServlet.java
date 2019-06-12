package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiajiu.dao.HouTai_ProductlistDao;
import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.ProductlistDao;
import com.jiajiu.dao.impl.HouTai_ProductlistDaoImpl;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiajiu.dao.impl.ProductlistDaoImpl;
import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;

public class HouTai_ProductlistServlet extends HttpServlet {

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

		HouTai_ProductlistDao htpldao=new HouTai_ProductlistDaoImpl();
		List<Product> prolists=new ArrayList<Product>();		
		prolists=htpldao.queryProduct();
		request.setAttribute("houtaiproductlist", prolists);
		
		ProductClassDao pcdao=new ProductClassDaoImpl();
		List<ProductClass> pclist=pcdao.queryProductClass();
		request.setAttribute("pclist", pclist);
		HttpSession session=request.getSession();

			request.getRequestDispatcher("/tgls/goodsManage/goods_list.jsp").forward(request, response);
		
		
		
		
		
		
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

		
	}

}
