package com.jiajiu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.NewsTypeDao;
import com.jiaju.entity.NewsType;
import com.jiaju.util.DBManager;
import com.mysql.jdbc.Statement;

public class NewsTypeDaoImpl implements NewsTypeDao {

	@Override
	public List<NewsType> queryNewsTypes() {
		List<NewsType> nts = new ArrayList<NewsType>();

		ResultSet rs = com.jiaju.util.DBManager
				.querySQL("select * from newstypeinfo");

		try {
			while (rs.next()) {

				NewsType nt = new NewsType();

				nt.setTypeid(rs.getInt(1));
				nt.setTypename(rs.getString(2));
				nts.add(nt);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return nts;

	}

	@Override
	public boolean delNewsType(int typeid) {
		int n = DBManager.updateSQL("delete from newstypeinfo where typeid="
				+ typeid);
		if (n == 1) {
			System.out.println("该类别删除成功");
			return true;
		} else {
			System.out.println("该类别删除失败");
			return false;
		}
	}

	@Override
	public boolean addNewsType(String typename) {
		int n = DBManager
				.updateSQL("insert into newstypeinfo (typename) values('"
						+ typename + "')");
		if (n == 1) {
			System.out.println("哈呀，加上了一个类别啊");
			return true;
		}
		System.out.println("怎么说，没把我加上吧");
		return false;
	}

	@Override
	public NewsType queryNewsTypeByID(int typeid) {
		// TODO Auto-generated method stub
		ResultSet rs = DBManager
				.querySQL("select * from newstypeinfo where typeid=" + typeid);
		try {
			while (rs.next()) {

				NewsType nt = new NewsType();
				nt.setTypeid(rs.getInt(1));
				nt.setTypename(rs.getString(2));
				return nt;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateNewsType(int typeid, String typename) {
		// TODO Auto-generated method stub
		
		int n=DBManager.updateSQL("update newstypeinfo set typename='"+typename+"'where typeid="+typeid);
		if(n>0){
			
			System.out.println("修改新闻类别SQL语句执行成功");
			return n;
		}else{
			System.out.println("修改新闻类别SQL语句执行失败");
			
		}
		
		
		return 0;
	}

}
