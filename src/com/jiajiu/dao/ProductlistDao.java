package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;

public interface ProductlistDao {

	
	
	/**
	 * ��ȡ���в�Ʒ
	 * @param typeid
	 * @return
	 */
	List<Product> queryProduct(int typeid);
	
	
	/**
	 * ��ȡ���в�Ʒ������
	 * @param typeid
	 * @return
	 */
	
	List<Product> queryProductwucan();
	
//	/**
//	 * ���չʾ6����Ʒ
//	 * @return
//	 */
//	List<Product>  queryProductRecommed();
	
	
	
	/**��̨������Ʒ
	 * ������Ʒ
	 */
	List<Product> queryProductSearch(Integer typeid,String name,String function,String content);
	/**
	 * ǰ̨������������ѯ
	 */
	
	List<Product> queryProductSearchs(String name);
	/**
	 * ���һ����Ʒ
	 */
	
int insertProduct(int typeid,String name,String function,Double price,String img,String content );
	
	/**
	 * ɾ��һ����Ʒ
	 * @param cpid
	 * @return
	 */

	boolean delproduct(int cpid);
	/**
	 * ��̨�޸Ĳ�Ʒ
	 */
	
	int updateProduct(int cpid,int typeid,String name,String function,Double price,String img,String content);
	
	/**
	 * ��̨���ֲ����cpid��ʾ
	 */
	Product queryById(int cpid);

	
	
	
	
	
	
	
	Product queryProById(int cpid);
	
}
