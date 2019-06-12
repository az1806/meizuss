package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiajiu.dao.ManagementDao;
import com.jiajiu.dao.impl.ManagementDaoImpl;
import com.jiaju.entity.Management;
import com.jiaju.servlet.admin.BaseServlet;
import com.jiaju.util.Result;

public class LoginServlet extends BaseServlet {

	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	response.setContentType("text/html");
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//	response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
String pwd=request.getParameter("password");


ManagementDao Mado=new ManagementDaoImpl();
Management mage=(Management)Mado.selectMageByBame(name,pwd);



PrintWriter out=response.getWriter();

if(mage.getUsername().equals(name)&&mage.getPwd().equals(pwd)){
	 HttpSession session = request.getSession();
     session.setAttribute("name", name);//session存放数据
    
	out.print(Result.toClient(true,"你的到来，使我们蓬荜生辉"));
}  else{ 
	
	
	if(mage.getPwd().equals(pwd)==false){
	out.print(Result.toClient(false,"再检查一下密码吧，可能输错了哦"));
	
}else if(mage.getUsername().equals(name)==false){
	out.print(Result.toClient(false, "我们这没有这个用户名哦"));
	
}


}
	}

}
