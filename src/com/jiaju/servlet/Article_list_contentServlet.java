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

	 /**
	  * ��ȡ�������
	  */
		NewsTypeDao	nsdao=new NewsTypeDaoImpl();
		
		List <NewsType> nts=(List<NewsType>) nsdao.queryNewsTypes();
				
				request.setAttribute("newstype",nts);
			
				
				/**
				 *����id����ʾ����
				 */
				Integer newsid=Integer.parseInt(request.getParameter("newsid"));
				     NewsDao ndao=new NewsDaoImpl();
				     News news=ndao.queryNewsByID(newsid);
				request.setAttribute("news", news);
				
				
				
				/**
				 * ��ȡ�����б�
				 */
				
				List<News> newslist=ndao.queryNewsDaowucan();
				request.setAttribute("newslist", newslist);	
				
				
				/**
				 * ��Ϊ�Ǹ���typeid�����Ʒ
				 * ���ǵ�һ�ν���ҳ���ȡ����typeid
				 * ������Ҫ�Ƚ��и�ֵ
				 * 
				 */
				int typeid;
				if(request.getParameter("typeid")==null){
					typeid=1;
				
				}else{
					
					typeid=Integer.parseInt(request.getParameter("typeid"));
				}
				/**
				 * ����typeid���������б�
				 */
				
		      NewsDao newsdao=new NewsDaoImpl();
				List<News> newslistid=newsdao.queryNewsDao(typeid);       
				request.setAttribute("newslistid",newslistid);
				/**
				 * ��ȡ��һ��
				 */
				
				
				request.getRequestDispatcher("article_list_content.jsp").forward(request, response);
			
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
