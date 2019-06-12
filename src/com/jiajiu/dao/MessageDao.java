package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Message;

public interface MessageDao {

	/**
	 * 插入一个留言
	 * @param lyid
	 * @param name
	 * @param phone
	 * @param email
	 * @param content
	 * @return
	 */
	int insertMess(Integer lyid,String name,String phone ,String email,String content);
	/**
	 * 后台显示留言内容
	 * @return
	 */
	List<Message> queryMessages();
	
	/**
	 * 后台删除留言
	 */
	
	int delMessage(int lyid);
	/**
	 * 后台修改状态
	 */
	int updateState(int lyid,String state);
	/**
	 * 后台根据留言查询
	 */
	List<Message>  queryMessageByState(String state);
}
