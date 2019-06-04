package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jiajiu.dao.BannersDao;
import com.jiajiu.dao.NewsDao;
import com.jiajiu.dao.NewsTypeDao;
import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.ProductlistDao;

import com.jiajiu.dao.impl.BannersDaoImpl;
import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiajiu.dao.impl.NewsTypeDaoImpl;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiajiu.dao.impl.ProductlistDaoImpl;
import com.jiaju.entity.Banners;
import com.jiaju.entity.Member;
import com.jiaju.entity.News;
import com.jiaju.entity.NewsType;
import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;

import com.jiajiu.dao.CompanyDao;
import com.jiajiu.dao.impl.CompanyDaoImpl;
import com.jiaju.entity.Company;


public class IndexServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		/**
		 * 获取公司信息;
		 */
		CompanyDao comDao = new CompanyDaoImpl();
		Company com = comDao.queryCompany();
		
		
		
	
	  request.setAttribute("company", com);
	  
	  
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
  * 获取所有类别;
  */
 
 ProductClassDao pcd=new ProductClassDaoImpl();		
  List<ProductClass> pts=pcd.queryProductClass();

 request.setAttribute("pts", pts);
	  
 /**
  * 获取新闻列表
  */
 
 NewsDao newsdao=new NewsDaoImpl();
 List<News> newslist=newsdao.queryNewsDaowucan();       
 request.setAttribute("newslist",newslist);
 
 /**
  * 获取轮播图
  */
 
 BannersDao bandao=new BannersDaoImpl();
 List<Banners> banlist=bandao.queryBanners();
 request.setAttribute("banlist",banlist);
	 
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
