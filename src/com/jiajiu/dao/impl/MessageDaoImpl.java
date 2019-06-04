package com.jiajiu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.MessageDao;
import com.jiaju.entity.Message;
import com.jiaju.util.DBManager;
import com.mysql.jdbc.ResultSet;

public class MessageDaoImpl implements MessageDao{

	

	@Override
	public boolean insertMess(Integer lyid, String name, String phone,
			String email, String content) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("insert messageinfo (name,phone,email,content) values('"+name+"','"+phone+"','"+email+"','"+content+"')");
		if(n==1){
			System.out.println("���Լ���ɹ�");
			return true;
		}
		System.out.println("���Լ���ʧ��");
		return false;
	}

	@Override
	public List<Message> queryMessages() {
		ResultSet rs=DBManager.querySQL("select * from messageinfo");
		List <Message> messlist=new ArrayList<Message>();
	
		try {
			while(rs.next()){
				Message message=new Message();
				message.setLyid(rs.getInt(1));
				message.setName(rs.getString(2));
				message.setPhone(rs.getString(3));
				message.setEmail(rs.getString(4));
				message.setContent(rs.getString(5));
				message.setState(rs.getString(6));
				
				messlist.add(message);
			}
			return messlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delMessage(int lyid) {
		// TODO Auto-generated method stub
	int n=DBManager.updateSQL("delete from messageinfo where lyid="+lyid);	
	if(n>0){
		System.out.println("SQL���ִ�гɹ�");
		return n;
	}else{
		System.out.println("Sql���ִ��ʧ��");
		return 0;
	}	
	
	
		
	}

	@Override
	public int updateState(int lyid, String state) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("update messageinfo set state='"+state+"' where lyid="+lyid);
		if(n>0){
			
			
			System.out.println("�޸�������Ϣsql���ִ�гɹ�");
			return n;
					 
		}else{
			
			System.out.println("�޸�������Ϣsql���ִ��ʧ��");
			return 0;
		}
		
		
	}

	@Override
	public List<Message> queryMessageByState(String state) {
		// TODO Auto-generated method stub
		List <Message> messlist=new ArrayList<Message>();
	  ResultSet rs=DBManager.querySQL("select * from messageinfo where state like '%"+state+"%'");
	  try {
		while(rs.next()){
			  Message message=new Message();
			  message.setLyid(rs.getInt(1));
				message.setName(rs.getString(2));
				message.setPhone(rs.getString(3));
				message.setEmail(rs.getString(4));
				message.setContent(rs.getString(5));
				message.setState(rs.getString(6));
				
				messlist.add(message);
			 
		  }
		 return messlist; 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
		
		
		
	

	
	
	}
}
