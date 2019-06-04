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
	 * @param typename
	 * @return
	 */
	boolean addNewsType(String typename);
	
	
	

}
