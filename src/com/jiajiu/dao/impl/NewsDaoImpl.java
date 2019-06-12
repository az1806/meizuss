package com.jiajiu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import com.jiajiu.dao.NewsDao;
import com.jiaju.entity.News;
import com.jiaju.util.DBManager;

public class NewsDaoImpl implements NewsDao {

	public List<News> queryNewsDao(int typeid) {

		List<News> ns = new ArrayList<News>();

		ResultSet rs = DBManager
				.querySQL("select * from newsinfo where typeid=" + typeid);

		try {
			while (rs.next()) {
				News n = new News();
				n.setNewsid(rs.getInt(1));
				n.setTypeid(rs.getInt(2));
				n.setTitle(rs.getString(3));
				n.setContent(rs.getString(4));
				n.setTime(rs.getDate(5));
				// n.setNewsid(rs.getInt(1));
				// n.setTypeid(rs.getInt(2));
				// n.setTitle(rs.getString(3));
				// n.setContent(rs.getString(4));
				// n.setTime(rs.getDate(5));
				ns.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ns;

	}

	@Override
	public List<News> queryNewsDaowucan() {
		List<News> ns = new ArrayList<News>();

		ResultSet rs = DBManager.querySQL("select * from newsinfo ");

		try {
			while (rs.next()) {
				News n = new News();
				n.setNewsid(rs.getInt(1));
				n.setTypeid(rs.getInt(2));
				n.setTitle(rs.getString(3));
				n.setContent(rs.getString(4));
				n.setTime(rs.getDate(5));

				ns.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ns;
	}

	@Override
	public boolean delnews(int newsid) {
		// TODO Auto-generated method stub
		int n = DBManager.updateSQL("delete from newsinfo where newsid="
				+ newsid);

		if (n == 1) {
			return true;
		}

		return false;
	}

	@Override
	/**
	 * 添加一个新闻
	 */
	public int addNews(int typeid, String title, String content, String time) {
		// TODO Auto-generated method stub

		int n = DBManager
				.updateSQL("insert into newsinfo (typeid,title,content,time) values('"
						+ typeid
						+ "','"
						+ title
						+ "','"
						+ content
						+ "','"
						+ time + "')");

		if (n > 0) {

			return n;

		}

		return 0;
	}

	@Override
	public int delNews(int newsid) {
		int n = DBManager.updateSQL("delete from newsinfo where newsid="
				+ newsid);
		if (n > 0) {
			return n;
		} else {

			return 0;
		}
	}

	/**
	 * 根据新闻id 来显示详情
	 */
	@Override
	public News queryNewsByID(int newsid) {
		ResultSet rs = DBManager
				.querySQL("select * from newsinfo where newsid=" + newsid);

		try {
			while (rs.next()) {

				News n = new News();
				n.setNewsid(rs.getInt(1));
				n.setTypeid(rs.getInt(2));
				n.setTitle(rs.getString(3));
				n.setContent(rs.getString(4));
				n.setTime(rs.getDate(5));

				return n;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	/**
 * 
 */
	@Override
	public int updateNewsById(int newsid, int typeid, String title,
			String content, String time) {
		// TODO Auto-generated method stub
		int n = DBManager.updateSQL("update newsinfo set typeid='" + typeid
				+ "',title='" + title + "',content='" + content + "',time='"
				+ time + "'where newsid=" + newsid);
		if (n > 0) {

			System.out.println("修改新闻SQL语句成功啦，很好，哈哈，高兴吧");
			return n;
		} else {
			System.out.println("修改新闻SQL语句失败啦，没事，继续加油");
			return 0;

		}

	}
/**
 * 多条件查询新闻列表
 */
	@Override
	public List<News> conditionquery(Integer typeid, String title,
			String content) {
		// TODO Auto-generated method stub
		String sql = "select * from newsinfo where 1=1";
		if (typeid>0) {
			sql +=" and typeid='" + typeid + "'";

		}
		if (title!=null&&!title.equals("")) {

			sql +=" and title like '%" + title + "%'";
		}

		if (content!=null&&!content.equals("") ) {

			sql +=" and content like '%" + content + "%'";
		}
		
      System.out.println(sql);
      
		ResultSet rs = DBManager.querySQL(sql);
		List<News> ns = new ArrayList<News>();
		try {
			while (rs.next()) {

				News n = new News();
				n.setNewsid(rs.getInt(1));
				n.setTypeid(rs.getInt(2));
				n.setTitle(rs.getString(3));
				n.setContent(rs.getString(4));
				n.setTime(rs.getDate(5));
				ns.add(n);

			}
			return ns;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
