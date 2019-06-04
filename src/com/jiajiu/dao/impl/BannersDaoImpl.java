package com.jiajiu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.BannersDao;
import com.jiaju.entity.Banners;
import com.jiaju.util.DBManager;

public class BannersDaoImpl implements BannersDao{

	@Override
	public List<Banners> queryBanners() {
		// TODO Auto-generated method stub
		
		ResultSet rs=DBManager.querySQL("select p.cpid,banner,p.name  from banners as b left join  productinfo as p on b.name=p.name");
		List <Banners> blist=new ArrayList<Banners>();
		
		try {
			while(rs.next()){
				Banners banners=new Banners();
				banners.setCpid(rs.getInt("cpid"));
				banners.setBanner(rs.getString(2));
				
				blist.add(banners);
				
				
				
			}
			return blist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
