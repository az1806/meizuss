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
import com.jiajiu.dao.ProductClassDao;
import com.jiajiu.dao.ProductlistDao;
import com.jiajiu.dao.impl.HouTai_ProductlistDaoImpl;
import com.jiajiu.dao.impl.MemberDaoImpl;
import com.jiajiu.dao.impl.NewsDaoImpl;
import com.jiajiu.dao.impl.ProductClassDaoImpl;
import com.jiajiu.dao.impl.ProductlistDaoImpl;
import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;
import com.jiaju.util.Result;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class ProductAdminServlet extends BaseServlet {

	
	
	/**
	 * 上传图片
	 */
	
	public void saveImg(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    PrintWriter out = response.getWriter();   
	   //1.创建SmartUpload
	    
	   SmartUpload smart =new SmartUpload();
	   //2.设置字符集
	   smart.setCharset("UTF-8");
	   //3.初始化
	   smart.initialize(getServletConfig(),request,response);
	  
	   try {
		   //4.上传文件
		smart.upload();
		//5.保存文件
		smart.save("/images");
		String filename=smart.getFiles().getFile(0).getFileName();
		
		out.println(Result.toClient(true,"images/"+filename));
	
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		out.print(Result.toClient(false, "图片保存失败"));
		e.printStackTrace();
	}
	    
	    
	    
	    
	    
	    
	    
	}
	
	
	
	
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
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
	
		  String name = java.net.URLDecoder.decode(request.getParameter("name"), "UTF-8");
		 System.out.println(name);
		 
		 Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		 System.out.println(typeid);
		 
		 
		 String function =request.getParameter("sfunction");
		 
		 System.out.println(function);
		 
		 String content = request.getParameter("content");
		 
		 System.out.println(content);
		List<Product> prosearch=prodao.queryProductSearch(typeid, name, function, content);
		if(prosearch!=null){
			System.out.println("产品检索成功");
			
		}else{
			System.out.println("产品检索失败");
		}
	      request.setAttribute("prosearch", prosearch);
	      /**
	       * 产品类别
	       */
	      ProductClassDao pcdao=new ProductClassDaoImpl();
			List<ProductClass> pclist=pcdao.queryProductClass();
			request.setAttribute("pclist", pclist);
			
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
//		  ProductClassDao pcdao=new ProductClassDaoImpl();
//			List<ProductClass> pclist=pcdao.queryProductClass();
//			request.setAttribute("pclist", pclist);
//			
//		  List<Product> prolist=prodao.queryProductwucan();
//		  request.setAttribute("houtaiproductlist", prolist);
//	    request.getRequestDispatcher("tgls/goodsManage/goods_list.jsp").forward(request, response);
		 out.print("<script>window.location.href=document.referrer</script>");
		  
	  }else{
		  out.println(Result.toClient(false, "看来还有挽救的余地"));
		  
	  }
		out.flush();
		out.close();
		
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
	  String name =request.getParameter("addname");
	  
	  String function = java.net.URLDecoder.decode(request.getParameter("addfunction"), "utf-8");
	  
	  Double price=Double.parseDouble(request.getParameter("addprice"));
	  
	  String img=request.getParameter("addimg");
	  
	  String content = java.net.URLDecoder.decode(request.getParameter("addcontent"), "utf-8");
		int n=prodao.insertProduct(typeid, name, function, price, img, content);
		
		if(n>0){
//			ProductClassDao pcdao=new ProductClassDaoImpl();
//			List<ProductClass> pclist=pcdao.queryProductClass();
//			request.setAttribute("pclist", pclist);
//			
//			List<Product> prolist=prodao.queryProductwucan();
//			  request.setAttribute("houtaiproductlist", prolist);
//		    request.getRequestDispatcher("tgls/goodsManage/goods_list.jsp").forward(request, response);
			out.print("<script>alert('增加成功');"+"window.location.href=document.referrer;</script>");
		}
		out.flush();
		out.close();
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
