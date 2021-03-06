package com.jiajiu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.ProductlistDao;
import com.jiaju.entity.Product;
import com.jiaju.util.DBManager;

public class ProductlistDaoImpl implements ProductlistDao{

	

	@Override
	public List<Product> queryProduct(int typeid) {
		// TODO Auto-generated method stub
		
		ResultSet rs=DBManager.querySQL("select * from productinfo where typeid="+typeid);
		List<Product> products=new ArrayList<Product>();
	
		 try {
			while(rs.next()){
				Product product=new Product();
				 product.setCpid(rs.getInt(1));
			
				 product.setTypeid(rs.getInt(2));
				 product.setName(rs.getString(3));
				 product.setFunction(rs.getString(4));
				 product.setPrice(rs.getDouble(5));
				 product.setImg(rs.getString(6));
				 product.setContent(rs.getString(7));
				 products.add(product);
				 
			 }
			 return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 return null;
	}

	


	@Override
	public List<Product> queryProductSearch(Integer typeid,String name,String function,String content) {
		
		String sql="SELECT * from productinfo where 1=1";
		
		if(typeid>0){
			sql+=" and typeid ='"+typeid+"'";
			
		}
		
		
		if(name!=null&&!name.equals("")){
			
			sql+=" and name like '%"+name+"%'";
		}
		if(function!=null&&!function.equals("")){
			
			sql+=" and function like '%"+function+"%'";
			
		}
		if(content!=null&&!content.equals("")){
			
			sql+=" and content like '%"+content+"%'";
		}
		
		System.out.println(sql);
		ResultSet rs=DBManager.querySQL(sql);
		
		
		List<Product> products=new ArrayList<Product>();
		
		 try {
			while(rs.next()){
				Product product=new Product();
				 product.setCpid(rs.getInt(1));
				 
				 product.setTypeid(rs.getInt(2));
				 
				 product.setName(rs.getString(3));
				 
				 product.setFunction(rs.getString(4));
				 
				 product.setPrice(rs.getDouble(5));
				 
				 product.setImg(rs.getString(6));
				 
				 product.setContent(rs.getString(7));
				 
				 products.add(product);
				 
			 }
			 return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 return null;
	}

	
	

	@Override
	public boolean delproduct(int cpid) {
		int n=DBManager.updateSQL("delete from productinfo where cpid="+cpid);
		if(n==1){
			return true;
		}
		
		return false;
	}

	@Override
	public int insertProduct(int typeid, String name, String function,
			Double price, String img, String content) {
	int n=DBManager.updateSQL("INSERT INTO productinfo(typeid,name,function,price,img,content) VALUES ('"+typeid+"','"+name+"','"+function+"','"+price+"','"+img+"','"+content+"')");
		if(n>0){
			System.out.println("商品加入成功");
			return n;
		}else{
			
			System.out.println("商品加入失败");
			return 0;
		}
	
	}

	@Override
	public int updateProduct(int cpid, int typeid, String name,
			String function, Double price, String img, String content) {
		// TODO Auto-generated method stub
		int n=DBManager.updateSQL("update productinfo set typeid='"+typeid+"',name='"+name+"',function='"+function+"',price='"+price+"',img='"+img+"',content='"+content+"'where cpid='"+cpid+"'");
      if(n>0){
    	  System.out.println("修改sql语句执行成功");
    	  return n;
      }else{
    	  System.out.println("修改sql语句执行失败");
		return 0;}
	}

	@Override
	public Product queryById(int cpid) {
		// TODO Auto-generated method stub
		ResultSet rs=DBManager.querySQL("select * from productinfo where cpid="+cpid);
		try {
			while(rs.next()){
				Product product=new Product();
				 product.setCpid(rs.getInt(1));
			
				 product.setTypeid(rs.getInt(2));
				 product.setName(rs.getString(3));
				 product.setFunction(rs.getString(4));
				 product.setPrice(rs.getDouble(5));
				 product.setImg(rs.getString(6));
				 product.setContent(rs.getString(7));
				return product;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> queryProductSearchs(String name) {
		// TODO Auto-generated method stub
		ResultSet rs=DBManager.querySQL("select * from productinfo where name like '%"+name+"%'");
		List<Product> products=new ArrayList<Product>();
		 try {
				while(rs.next()){
					Product product=new Product();
					 product.setCpid(rs.getInt(1));
					 
					 product.setTypeid(rs.getInt(2));
					 
					 product.setName(rs.getString(3));
					 
					 product.setFunction(rs.getString(4));
					 
					 product.setPrice(rs.getDouble(5));
					 
					 product.setImg(rs.getString(6));
					 
					 product.setContent(rs.getString(7));
					 
					 products.add(product);
					 
				 }
				 return products;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		return null;
	}




	@Override
	public List<Product> queryProductwucan() {
		// TODO Auto-generated method stub
		
				ResultSet rs=DBManager.querySQL("select * from productinfo");
				List<Product> products=new ArrayList<Product>();
			
				 try {
					while(rs.next()){
						Product product=new Product();
						 product.setCpid(rs.getInt(1));
					
						 product.setTypeid(rs.getInt(2));
						 product.setName(rs.getString(3));
						 product.setFunction(rs.getString(4));
						 product.setPrice(rs.getDouble(5));
						 product.setImg(rs.getString(6));
						 product.setContent(rs.getString(7));
						 products.add(product);
						 
					 }
					 return products;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				 return null;
	}




	@Override
	public Product queryProById(int cpid) {
		// TODO Auto-generated method stub
				ResultSet rs=DBManager.querySQL("select * from productinfo where cpid="+cpid);
				try {
					while(rs.next()){
						Product product=new Product();
						 product.setCpid(rs.getInt(1));
					
						 product.setTypeid(rs.getInt(2));
						 product.setName(rs.getString(3));
						 product.setFunction(rs.getString(4));
						 product.setPrice(rs.getDouble(5));
						 product.setImg(rs.getString(6));
						 product.setContent(rs.getString(7));
						return product;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	

	

}
