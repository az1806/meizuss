package com.jiajiu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.HouTai_ProductlistDao;
import com.jiaju.entity.Product;
import com.jiaju.util.DBManager;
import com.mysql.jdbc.ResultSet;

public class HouTai_ProductlistDaoImpl implements HouTai_ProductlistDao{

	@Override
	public List<Product> queryProduct() {
		
		ResultSet rs=DBManager.querySQL("select * from productinfo");
		List<Product> prolists=new ArrayList<Product>();
		
		try {
			while(rs.next()){
				
				Product prolist=new Product();
				
				prolist.setCpid(rs.getInt(1));
				prolist.setTypeid(rs.getInt(2));
				prolist.setName(rs.getString(3));
				prolist.setFunction(rs.getString(4));
				prolist.setPrice(rs.getDouble(5));
				prolist.setImg(rs.getString(6));
				prolist.setContent(rs.getString(7));
				prolists.add(prolist);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(prolists);
		// TODO Auto-generated method stub
		return prolists;
	}

}
