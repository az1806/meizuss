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
	/**
	 * 后台修改产品列表
	 */
	int updateProductClass(int typeid,String typename);
	/**
	 * 后台回显数据
	 */
	ProductClass queryPCById(int typeid);
}
