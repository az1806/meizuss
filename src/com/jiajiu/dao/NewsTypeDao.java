package com.jiajiu.dao;


import java.util.List;

import com.jiaju.entity.NewsType;



public interface NewsTypeDao {

/**
 * 删除一个类别
 * @param typeid
 * @return
 */
	boolean delNewsType(int typeid);
	
	List<NewsType> queryNewsTypes();
	
	
	/**
	 * 增加一个类别
	 * @param typeid
	 * @param 类别名称
	 * @return
	 */
	boolean addNewsType(String typename);
	/**
	 * 根据typeid显示类别名称
	 * @param typeid
	 * @return
	 */
	NewsType queryNewsTypeByID(int typeid);
	
	int updateNewsType(int typeid,String typename);

}
