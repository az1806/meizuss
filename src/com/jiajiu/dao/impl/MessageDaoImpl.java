package com.jiajiu.dao.impl;

import com.jiajiu.dao.MessageDao;
import com.jiaju.util.DBManager;

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

	
	
	
}
