package com.jiajiu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiajiu.dao.ProductClassDao;
import com.jiaju.entity.ProductClass;
import com.jiaju.util.DBManager;
import com.mysql.jdbc.ResultSet;

public class ProductClassDaoImpl implements ProductClassDao {

	public List<ProductClass> queryProductClass() {
		List<ProductClass> pts = new ArrayList<ProductClass>();

		

		ResultSet rs =	DBManager.querySQL("select * from productClassinfo");
		try {
			while (rs.next()) {
				ProductClass pc = new ProductClass();
				pc.setTypeid(rs.getInt(1));
				pc.setTypename(rs.getString(2));
				pts.add(pc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pts;
	}

	@Override
	public boolean addProductType(String typename) {
		// TODO Auto-generated method stub
		int n = DBManager
				.updateSQL("insert  into  productclassinfo (typename) values('"
						+ typename + "')");
		if (n == 1) {
			System.out.println("产品类别加入成功");
			return true;
		} else {
			System.out.println("产品类别加入失败喽");
		}
		return false;
	}

	@Override
	public boolean delProductType(int type) {
		// TODO Auto-generated method stub

		int n = DBManager
				.updateSQL("delete from productclassinfo where typeid=" + type);

		if (n == 1) {
			System.out.println("哎呀，该类别被你删啦，不要后悔哦");
			return true;
		} else {
			System.out.println("哈哈，想把我删掉 ，在检查 检查代码吧");
			return false;
		}

	}

	@Override
	public int updateProductClass(int typeid, String typename) {
		int n = DBManager.updateSQL("update productclassinfo set typename='"
				+ typename + "' where typeid=" + typeid);

		if (n > 0) {
			System.out.println("产品类别修改sql语句执行成功");
			return n;
		}

		System.out.println("产品类别修改sql语句执行失败");
		return 0;
	}

	@Override
	public ProductClass queryPCById(int typeid) {
		// TODO Auto-generated method stub

		ResultSet rs = DBManager
				.querySQL("select * from productclassinfo where typeid="
						+ typeid);

		try {
			while (rs.next()) {

				int id = rs.getInt(1);
				String typename = rs.getString(2);
				ProductClass pc = new ProductClass(id, typename);
				return pc;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;

	}

}
