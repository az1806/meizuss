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
	/**
	 * ��̨�޸Ĳ�Ʒ�б�
	 */
	int updateProductClass(int typeid,String typename);
	/**
	 * ��̨��������
	 */
	ProductClass queryPCById(int typeid);
}
