package com.jiajiu.dao;


import java.util.List;

import com.jiaju.entity.NewsType;



public interface NewsTypeDao {

/**
 * ɾ��һ�����
 * @param typeid
 * @return
 */
	int delNewsType(int typeid);
	
	/**
	 * ��ʾ�������ŷ����б�
	 * @return
	 */
	List<NewsType> queryNewsTypes();
	
	
	/**
	 * ����һ�����
	 * @param typeid
	 * @param �������
	 * @return
	 */
	int addNewsType(String typename);
	/**
	 * ����typeid��ʾ�������
	 * @param typeid
	 * @return
	 */
	NewsType queryNewsTypeByID(int typeid);
	
	int updateNewsType(int typeid,String typename);

}
