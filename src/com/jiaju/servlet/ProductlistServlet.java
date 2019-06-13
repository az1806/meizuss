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

public class ProductlistServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		 ProductClassDao pcd=new ProductClassDaoImpl();		
		 
		   List<ProductClass> pts=  pcd.queryProductClass();
				
			 request.setAttribute("productclass",pts);
	
			 
			/**
			 * 获取typeid 
			 */
			 
		   int typeid;
		   if(request.getParameter("typeid")==null){
			   typeid=1;	 
		   }else{
			   
			   typeid=Integer.parseInt(request.getParameter("typeid"));
			   
		   }
	 
		/**
		 * 根据产品类别进行显示;
		 */
		 
         ProductlistDao productdao=new ProductlistDaoImpl();
        List<Product> plist=productdao.queryProduct(typeid);
        
        request.setAttribute("plist",plist);
        
        
        
        /**
         * 根据搜索内容进行显示
         **/ 
        
        
        ProductlistDao prosear=new ProductlistDaoImpl();
        
	       String name=request.getParameter("name"); 
	       
	       List<Product> names=prosear.queryProductSearchs(name);
	       
	       request.setAttribute("names",names);
	       
	       
	       
	       
	       int cpid;
	       if(request.getParameter("cpid")!=null){
	 		   
	     	  cpid=Integer.parseInt(request.getParameter("cpid"));
	     	  
	 	   }
	       else{
	 		   cpid=1;
	 	   }
	       
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
