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
		 * ��ȡ���ŷ����б�
		 */
		NewsTypeDao	nsdao=new NewsTypeDaoImpl();
		
       List <NewsType> nts=(List<NewsType>) nsdao.queryNewsTypes();
       
       request.setAttribute("newstype",nts);
       
       
       
       
       /**
        * ��ȡtypeid
        */
       int typeid;
       
		if(request.getParameter("typeid")==null){
			typeid=1;
		
		}else{
			
			typeid=Integer.parseInt(request.getParameter("typeid"));
		}


/**
 * ���������Է���������б�		
 */
		
NewsDao newsdao=new NewsDaoImpl();

List<News> newslist=newsdao.queryNewsDao(typeid);       
request.setAttribute("newslist",newslist);


/**
 * ����������ʾ�������ݵ��б�
 */

int newsid;
if(request.getParameter("newsid")!=null){
	
	newsid=Integer.parseInt(request.getParameter("newsid"));
	
}
/**
 * ��������
 */

NewsDao newsdaowucan=new NewsDaoImpl();
List<News> newslistwucan=newsdaowucan.queryNewsDaowucan();       
request.setAttribute("newslistwucan",newslistwucan);

		
		System.out.println("���ݼ������");	
		
		
	
		
		
		request.getRequestDispatcher("article_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
