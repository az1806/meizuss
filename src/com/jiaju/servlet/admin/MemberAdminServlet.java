package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiajiu.dao.CompanyDao;
import com.jiajiu.dao.MemberDao;
import com.jiajiu.dao.impl.CompanyDaoImpl;
import com.jiajiu.dao.impl.MemberDaoImpl;
import com.jiaju.entity.Company;
import com.jiaju.entity.Member;
import com.jiaju.util.Result;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class MemberAdminServlet extends BaseServlet {

	

	/**
	 * �ϴ�ͼƬ
	 */
	
	public void saveImg(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    PrintWriter out = response.getWriter();   
	   //1.����SmartUpload
	    
	   SmartUpload smart =new SmartUpload();
	   //2.�����ַ���
	   smart.setCharset("UTF-8");
	   //3.��ʼ��
	   smart.initialize(getServletConfig(),request,response);
	  
	   try {
		   //4.�ϴ��ļ�
		smart.upload();
		//5.�����ļ�
		smart.save("/images");
		String filename=smart.getFiles().getFile(0).getFileName();
		
		out.println(Result.toClient(true,"images/"+filename));
	
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		out.print(Result.toClient(false, "ͼƬ����ʧ��"));
		e.printStackTrace();
	}
	
	    
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();

		MemberDao memberdao=new MemberDaoImpl();
		Integer id=null;
		String name = java.net.URLDecoder.decode(request.getParameter("name"), "utf-8");
		String position = java.net.URLDecoder.decode(request.getParameter("position"), "utf-8");
		String photo = java.net.URLDecoder.decode(request.getParameter("photo"), "utf-8");
		
		
		boolean judge=memberdao.AddMember(id, name, position, photo);
		
               if(judge){		   
            		
            	   out.print("<script>alert('���ӳɹ�');"+"window.location.href=document.referrer;</script>");
		}else{	
			out.println(Result.toClient(false,"��Ա����ʧ��"));
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
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		MemberDao memberdao=new MemberDaoImpl();
		Integer id=Integer.parseInt(request.getParameter("id"));
		boolean judge=memberdao.DelMember(id);
		if(judge){
			
			 out.print("<script>window.location.href=document.referrer;</script>");
			
			
		}else{
			out.println(Result.toClient(false, "������λ���ѻ�û��ʱ���뿪"));
		}
		
	}
	public void zhezao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
       Integer id=Integer.parseInt(request.getParameter("id"));
       MemberDao memberdao=new MemberDaoImpl();
       Member mem=memberdao.ObjMember(id);
       request.setAttribute("mem", mem);
       
		request.getRequestDispatcher("tgls/memberManage/member_update.jsp").forward(request, response);
	
	}
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
       Integer id=Integer.parseInt(request.getParameter("id"));
       MemberDao memberdao=new MemberDaoImpl();
       
       String name = java.net.URLDecoder.decode(request.getParameter("name"), "utf-8");
		String position = java.net.URLDecoder.decode(request.getParameter("position"), "utf-8");
		String photo = java.net.URLDecoder.decode(request.getParameter("photo"), "utf-8");
		
       int n=memberdao.UpdateMember(id, name, position, photo);
        PrintWriter out=response.getWriter();
       
       if(n>0){
    	   System.out.println("�޸ĳɹ�");
    	   out.println("<script>window.parent.location.reload()</script>");
			
       }else{
    	   System.out.println("�޸�ʧ��");
       }
		
	
	}

}
