package com.jiajiu.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import com.jiajiu.dao.NewsDao;
import com.jiaju.entity.News;
import com.jiaju.util.DBManager;

public class NewsDaoImpl implements NewsDao {

	public List<News> queryNewsDao(int typeid) {
		
		List<News> ns=new ArrayList<News> ();
		
		ResultSet rs=DBManager.querySQL("select * from newsinfo where typeid="+typeid
				);
		
		try{
			while(rs.next()){
				News n=new News();
				n.setNewsid(rs.getInt(1));
			   n.setTypeid(rs.getInt(2));
			   n.setTitle(rs.getString(3));
			   n.setContent(rs.getString(4));
		   n.setTime(rs.getDate(5));
//				n.setNewsid(rs.getInt(1));
//				n.setTypeid(rs.getInt(2));
//				n.setTitle(rs.getString(3));
//				n.setContent(rs.getString(4));
//				n.setTime(rs.getDate(5));
			   ns.add(n);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ns;
	
	}

	@Override
	public List<News> queryNewsDaowucan() {
List<News> ns=new ArrayList<News> ();
		
		ResultSet rs=DBManager.querySQL("select * from newsinfo ");
				
		
		try{
			while(rs.next()){
				News n=new News();
				n.setNewsid(rs.getInt(1));
			   n.setTypeid(rs.getInt(2));
			   n.setTitle(rs.getString(3));
			   n.setContent(rs.getString(4));
		   n.setTime(rs.getDate(5));
//				n.setNewsid(rs.getInt(1));
//				n.setTypeid(rs.getInt(2));
//				n.setTitle(rs.getString(3));
//				n.setContent(rs.getString(4));
//				n.setTime(rs.getDate(5));
			   ns.add(n);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ns;
	}

	@Override
	public boolean delnews(int newsid) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("delete from newsinfo where newsid="+newsid);
		
		if(n==1){
			return true;
		}
		
		return false;
	}

	@Override
	/**
	 * 添加一个新闻
	 */
	public int addNews(int typeid,String title,String content,String time){
		// TODO Auto-generated method stub
		
		int n=DBManager.updateSQL("insert into newsinfo (typeid,title,content,time) values('"+typeid+"','"+title+"','"+content+"','"+time+"')");
		
		if(n>0){
			
			return n;
			
		}
		
		
		return 0;
	}

	@Override
	public int delNews(int newsid) {
		int n=DBManager.updateSQL("delete from newsinfo where newsid="+newsid);
		if(n>0){
			return n;
		}
		else{
			
			return 0;
		}
	}



}
