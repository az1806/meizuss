package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.MessageDao;
import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.impl.MessageDaoImpl;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiaju.entity.Message;
import com.jiaju.entity.ProductClass;
import com.jiaju.util.Result;

public class ProductTypeAdmin extends BaseServlet {

	/**
	 * ���һ����Ʒ���
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
//			ProductClassDao proclassdao=new ProductClassDaoImpl();
//			List<ProductClass> proclasslist=proclassdao.queryProductClass();
//			request.setAttribute("hproductclass",proclasslist);
//			
//			request.getRequestDispatcher("tgls/goodsManage/goodsType_list.jsp").forward(request, response);
			out.print("<script>alert('���ӳɹ�');"+"window.location.href=document.referrer;</script>");
			
		}
		out.flush();
		out.close();
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
//			ProductClassDao proclassdao=new ProductClassDaoImpl();
//			List<ProductClass> proclasslist=proclassdao.queryProductClass();
//			request.setAttribute("hproductclass",proclasslist);
//			
//			request.getRequestDispatcher("tgls/goodsManage/goodsType_list.jsp").forward(request, response);
			out.print("<script>window.location.href=document.referrer;</script>");
		}
		out.flush();
		out.close();
		
	}
	/**
	 * ����һ������������������
	 */

	public void zhezhao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
             ProductClassDao pcdao=new ProductClassDaoImpl(); 
             
             int typeid=Integer.parseInt(request.getParameter("typeid"));
             
		     ProductClass pc=pcdao.queryPCById(typeid);
		     
		      request.setAttribute("pc", pc);
		      
		  	request.getRequestDispatcher("tgls/goodsManage/goodsType_update.jsp").forward(request, response);
		

	}
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
             ProductClassDao pcdao=new ProductClassDaoImpl(); 
             PrintWriter out=response.getWriter();
             Integer typeid=Integer.parseInt(request.getParameter("typeid"));
             String typename=request.getParameter("typename");
          int n=pcdao.updateProductClass(typeid, typename);
          if(n>0){
        	  System.out.println("��Ʒ����޸ĳɹ�");
        	  out.print("<script>window.parent.location.reload()</script>");
      
       	  
          }else{
        	  
        	  System.out.println("��Ʒ����޸�ʧ��");
        	  
          }
          out.flush();
  		out.close();
	}

}
