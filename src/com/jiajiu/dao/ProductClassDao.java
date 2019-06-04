package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.ProductClass;

public interface ProductClassDao {
	/**
	 * 获取所有产品类别
	 * @return
	 */
	List<ProductClass> queryProductClass();
	
	boolean addProductType(String typename);
	
	boolean delProductType(int typeid);
	
	
}
