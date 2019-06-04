package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiaju.entity.ProductClass;
import com.jiaju.util.Result;

public class ProductTypeAdmin extends BaseServlet {

	/**
	 * 添加一个商品类别
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();

		String typename = java.net.URLDecoder.decode(request.getParameter("typename"), "utf-8");
		ProductClassDao  pcd=new ProductClassDaoImpl();
	   boolean  judge=	pcd.addProductType(typename);
		if(judge){	
			
			ProductClassDao proclassdao=new ProductClassDaoImpl();
			List<ProductClass> proclasslist=proclassdao.queryProductClass();
			request.setAttribute("hproductclass",proclasslist);
			
			request.getRequestDispatcher("tgls/goodsManage/goodsType_list.jsp").forward(request, response);
		}else{
			
			out.println(Result.toClient(false,"产品类别加入失败servlet"));
		}
	 }
	
	
	
	
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		
		ProductClassDao pcd=new ProductClassDaoImpl();
		boolean judge=pcd.delProductType(typeid);
		if(judge){
			ProductClassDao proclassdao=new ProductClassDaoImpl();
			List<ProductClass> proclasslist=proclassdao.queryProductClass();
			request.setAttribute("hproductclass",proclasslist);
			
			request.getRequestDispatcher("tgls/goodsManage/goodsType_list.jsp").forward(request, response);
			
		}else{
			
			out.println("没有删除成功");
		}
		
	}

}
