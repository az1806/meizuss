package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Message;

public interface MessageDao {

	/**
	 * ����һ������
	 * @param lyid
	 * @param name
	 * @param phone
	 * @param email
	 * @param content
	 * @return
	 */
	int insertMess(Integer lyid,String name,String phone ,String email,String content);
	/**
	 * ��̨��ʾ��������
	 * @return
	 */
	List<Message> queryMessages();
	
	/**
	 * ��̨ɾ������
	 */
	
	int delMessage(int lyid);
	/**
	 * ��̨�޸�״̬
	 */
	int updateState(int lyid,String state);
	/**
	 * ��̨�������Բ�ѯ
	 */
	List<Message>  queryMessageByState(String state);
}
