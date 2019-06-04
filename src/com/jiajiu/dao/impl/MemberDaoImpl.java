package com.jiajiu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.MemberDao;
import com.jiaju.entity.Member;
import com.jiaju.util.DBManager;

public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> queryMember() {
		ResultSet rs=DBManager.querySQL("select * from memberinfo");
		
		List<Member> members=new ArrayList<Member>();
		
		try {
			while(rs.next()){
				Member member=new Member();
				member.setId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setPosition(rs.getString(3));
				member.setPhoto(rs.getString(4));
				members.add(member);
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		return members;
	}

	@Override
	public boolean AddMember(Integer id, String name, String position,
			String photo) {
		// TODO Auto-generated method stub
		
		int n=DBManager.updateSQL("insert memberinfo (name,position,photo) values('"+name+"','"+position+"','"+photo+"')");
		if(n==1){
			
			System.out.println("成员加入成功");
			return true;
			
		}else
			return false;
		
	}

	@Override
	public boolean DelMember(int id) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("delete from Memberinfo where id="+id);
		
		if(n==1){
			return true;
		}
		
		
		return false;
	}

	@Override
	public Member ObjMember(int id) {
		ResultSet rs=DBManager.querySQL("select * from memberinfo where id="+id);
		Member member=new Member();
		try {
			while(rs.next()){
				
				  member.setId(rs.getInt(1));
				  member.setName(rs.getString(2));
				  member.setPosition(rs.getString(3));
				member.setPhoto(rs.getString(4));
			
			}
			System.out.println(member);
			return member;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public int UpdateMember(int id, String name, String position, String photo) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("update memberinfo set name='"+name+"',position ='"+position+"',photo='"+photo+"'where id='"+id+"'");
		if(n>0){
			return n;
			
		}
		return 0;
	}

	

}
