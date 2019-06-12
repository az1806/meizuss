package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Product;
import com.jiaju.entity.ProductClass;

public interface ProductlistDao {

	
	
	/**
	 * 获取所有产品
	 * @param typeid
	 * @return
	 */
	List<Product> queryProduct(int typeid);
	
	
	/**
	 * 获取所有产品不分类
	 * @param typeid
	 * @return
	 */
	
	List<Product> queryProductwucan();
	
//	/**
//	 * 随机展示6个产品
//	 * @return
//	 */
//	List<Product>  queryProductRecommed();
	
	
	
	/**后台搜索产品
	 * 搜索产品
	 */
	List<Product> queryProductSearch(Integer typeid,String name,String function,String content);
	/**
	 * 前台根据名字来查询
	 */
	
	List<Product> queryProductSearchs(String name);
	/**
	 * 添加一个商品
	 */
	
int insertProduct(int typeid,String name,String function,Double price,String img,String content );
	
	/**
	 * 删除一个产品
	 * @param cpid
	 * @return
	 */

	boolean delproduct(int cpid);
	/**
	 * 后台修改产品
	 */
	
	int updateProduct(int cpid,int typeid,String name,String function,Double price,String img,String content);
	
	/**
	 * 后台遮罩层根据cpid显示
	 */
	Product queryById(int cpid);

	
	
	
	
	
	
	
	Product queryProById(int cpid);
	
}
