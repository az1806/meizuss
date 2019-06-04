package com.jiaju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.CompanyDao;
import com.jiajiu.dao.MemberDao;

import com.jiajiu.dao.impl.CompanyDaoImpl;
import com.jiajiu.dao.impl.MemberDaoImpl;

import com.jiaju.entity.Company;
import com.jiaju.entity.Member;

public class AboutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CompanyDao comDao = new CompanyDaoImpl();
		Company com = comDao.queryCompany();
		request.setAttribute("company", com);
		
		
		
		MemberDao memdao=new MemberDaoImpl();
		List<Member> mems=new ArrayList();
		mems=memdao.queryMember();
		request.setAttribute("mems",mems);
		
		request.getRequestDispatcher("about.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
