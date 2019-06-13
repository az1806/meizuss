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

public class Article_listServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		/**
		 * 获取新闻分类列表
		 */
		NewsTypeDao	nsdao=new NewsTypeDaoImpl();
		
       List <NewsType> nts=(List<NewsType>) nsdao.queryNewsTypes();
       
       request.setAttribute("newstype",nts);
       
       
       
       
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
 * 带参数可以分类的新闻列表		
 */
		
NewsDao newsdao=new NewsDaoImpl();

List<News> newslist=newsdao.queryNewsDao(typeid);       
request.setAttribute("newslist",newslist);


/**
 * 不带参数显示新闻内容的列表
 */

int newsid;
if(request.getParameter("newsid")!=null){
	
	newsid=Integer.parseInt(request.getParameter("newsid"));
	
}
/**
 * 更多新闻
 */

NewsDao newsdaowucan=new NewsDaoImpl();
List<News> newslistwucan=newsdaowucan.queryNewsDaowucan();       
request.setAttribute("newslistwucan",newslistwucan);

		
		System.out.println("数据加载完成");	
		
		
	
		
		
		request.getRequestDispatcher("article_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
