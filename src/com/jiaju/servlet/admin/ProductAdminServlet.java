package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.HouTai_ProductlistDao;
import com.jiajiu.dao.MemberDao;
import com.jiajiu.dao.NewsDao;
import com.jiajiu.dao.ProductlistDao;
import com.jiajiu.dao.impl.HouTai_ProductlistDaoImpl;
import com.jiajiu.dao.impl.MemberDaoImpl;
import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiajiu.dao.impl.ProductlistDaoImpl;
import com.jiaju.entity.Product;
import com.jiaju.util.Result;

public class ProductAdminServlet extends BaseServlet {

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
	ProductlistDao prodao=new ProductlistDaoImpl();
	/**
	 * 搜索产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		 String name = java.net.URLDecoder.decode(request.getParameter("name"), "utf-8");

		List<Product> prosearch=prodao.queryProductSearch(name);
		if(prosearch!=null){
			System.out.println("产品检索成功");
			
		}else{
			System.out.println("产品检索失败");
		}
	      request.setAttribute("prosearch", prosearch);
	      
	      
	      HouTai_ProductlistDao htpldao=new HouTai_ProductlistDaoImpl();
			List<Product> prolists=new ArrayList<Product>();		
			prolists=htpldao.queryProduct();
			request.setAttribute("houtaiproductlist", prolists);
	      request.getRequestDispatcher("tgls/goodsManage/goods_list.jsp").forward(request, response);
		
		
		
	}
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
	  int cpid=Integer.parseInt(request.getParameter("cpid"));
	  
	  boolean judge=prodao.delproduct(cpid);
	  if(judge){
		 
		  List<Product> prolist=prodao.queryProductwucan();
		  request.setAttribute("houtaiproductlist", prolist);
	    request.getRequestDispatcher("tgls/goodsManage/goods_list.jsp").forward(request, response);
		 
	  }else{
		  out.println(Result.toClient(false, "看来还有挽救的余地"));
		  
	  }
		
		
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
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	  int typeid=Integer.parseInt( request.getParameter("addtypeid"))  ;
	  String name = java.net.URLDecoder.decode(request.getParameter("addname"), "utf-8");
	  
	  String function = java.net.URLDecoder.decode(request.getParameter("addfunction"), "utf-8");
	  
	  Double price=Double.parseDouble(request.getParameter("addprice"));
	  
	  String img=request.getParameter("addimg");
	  
	  String content = java.net.URLDecoder.decode(request.getParameter("addcontent"), "utf-8");
		int n=prodao.insertProduct(typeid, name, function, price, img, content);
		
		if(n>0){
			List<Product> prolist=prodao.queryProductwucan();
			  request.setAttribute("houtaiproductlist", prolist);
		    request.getRequestDispatcher("tgls/goodsManage/goods_list.jsp").forward(request, response);
			 
		}
		
	}
	
	
	public void zhezhao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
	  int cpid=Integer.parseInt(request.getParameter("cpid"));
      ProductlistDao prodao=new ProductlistDaoImpl();
      Product pro=prodao.queryById(cpid);
      request.setAttribute("pro", pro);
      
      request.getRequestDispatcher("tgls/goodsManage/goods_update.jsp").forward(request, response);
	
		
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		PrintWriter out = response.getWriter();
		 int cpid=Integer.parseInt( request.getParameter("cpid"))  ;
	  int typeid=Integer.parseInt( request.getParameter("typeid"))  ;
	  String name = request.getParameter("name");
	  
	  String function = request.getParameter("updatefunction");
	  
	  Double price=Double.parseDouble(request.getParameter("price"));
	  
	  String img=request.getParameter("img");
	  
	  String content = request.getParameter("content");
		int n=prodao.updateProduct(cpid, typeid, name, function, price, img, content);
		
		   if(n>0){
	    	   System.out.println("修改成功");
	    	   out.println("<script>window.parent.location.reload()</script>");
				
	       }else{
	    	   System.out.println("修改失败");
	       }
		
	}
	

}
