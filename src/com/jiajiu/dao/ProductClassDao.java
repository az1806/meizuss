package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.ProductClass;

public interface ProductClassDao {
	/**
	 * ��ȡ���в�Ʒ���
	 * @return
	 */
	List<ProductClass> queryProductClass();
	
	boolean addProductType(String typename);
	
	boolean delProductType(int typeid);
	
	
}
