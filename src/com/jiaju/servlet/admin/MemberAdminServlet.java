package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.MemberDao;
import com.jiajiu.dao.impl.MemberDaoImpl;
import com.jiaju.entity.Member;
import com.jiaju.util.Result;

public class MemberAdminServlet extends BaseServlet {

	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDao memberdao=new MemberDaoImpl();
			List<Member> member=memberdao.queryMember();
			request.setAttribute("memlist", member);
			
			int memid;
			
			if(request.getParameter("memid")!=null){
				memid=Integer.parseInt(request.getParameter("memid"));
				
			}else
			{memid=1;}
		
			
			Member mem=memberdao.ObjMember(memid);
			request.setAttribute("mem", mem);
			
			
			
	request.getRequestDispatcher("tgls/memberManage/memberlist.jsp").forward(request, response);
	
		
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
            		List<Member> member=memberdao.queryMember();
        			request.setAttribute("memlist", member);
        			request.getRequestDispatcher("tgls/memberManage/memberlist.jsp").forward(request, response);
		}else{	
			out.println(Result.toClient(false,"产品类别加入失败servlet"));
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
			
			out.println(Result.toClient(true, "让我们向这位朋友告别吧"));
			List<Member> member=memberdao.queryMember();
			request.setAttribute("memlist", member);
			request.getRequestDispatcher("tgls/memberManage/memberlist.jsp").forward(request, response);
			
			
			
		}else{
			out.println(Result.toClient(false, "看来这位朋友还没到时候离开"));
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
    	   System.out.println("修改成功");
    	   out.println("<script>window.parent.location.reload()</script>");
			
       }else{
    	   System.out.println("修改失败");
       }
		
	
	}

}
