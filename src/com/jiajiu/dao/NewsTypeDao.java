package com.jiajiu.dao;


import java.util.List;

import com.jiaju.entity.NewsType;



public interface NewsTypeDao {

/**
 * ɾ��һ�����
 * @param typeid
 * @return
 */
	boolean delNewsType(int typeid);
	
	List<NewsType> queryNewsTypes();
	
	
	/**
	 * ����һ�����
	 * @param typeid
	 * @param typename
	 * @return
	 */
	boolean addNewsType(String typename);
	
	
	

}
