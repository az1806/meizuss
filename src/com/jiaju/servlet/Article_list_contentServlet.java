package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.NewsDao;
import com.jiajiu.dao.NewsTypeDao;
import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiajiu.dao.impl.NewsTypeDaoImpl;
import com.jiaju.entity.News;
import com.jiaju.entity.NewsType;

public class Article_list_contentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		NewsTypeDao	nsdao=new NewsTypeDaoImpl();
		
		List <NewsType> nts=(List<NewsType>) nsdao.queryNewsTypes();
				
				request.setAttribute("newstype",nts);
				System.out.println("数据加载完成");
				
				
				/**
				 *根据id来显示详情
				 */
				Integer newsid=Integer.parseInt(request.getParameter("newsid"));
				     NewsDao ndao=new NewsDaoImpl();
				     News news=ndao.queryNewsByID(newsid);
				request.setAttribute("news", news);
				
				
				
				List<News> newslist=ndao.queryNewsDaowucan();
				request.setAttribute("newslist", newslist);	
				
				
				int typeid;
				if(request.getParameter("typeid")==null){
					typeid=nts.get(0).getTypeid();
				
				}else{
					
					typeid=Integer.parseInt(request.getParameter("typeid"));
				}

				
				NewsDao newsdao=new NewsDaoImpl();
				List<News> newslistid=newsdao.queryNewsDao(typeid);       
				request.setAttribute("newslistid",newslistid);
				
				request.getRequestDispatcher("article_list_content.jsp").forward(request, response);
			
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
