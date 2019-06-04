package com.jiajiu.dao;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jiaju.entity.News;

public interface NewsDao {
	/**
	 * 通过news列表typeid进行类别切换
	 * @param typeid
	 * @return
	 */
		List<News> queryNewsDao(int typeid); 
		/**
		 * 不进行类别切换
		 * @param typeid
		 * @return
		 */
		
		List<News> queryNewsDaowucan(); 
		/**
		 * 删除一个资讯
		 */
		boolean delnews(int newsid);
		
		
		int addNews(int typeid,String title,String content,String time);
	
	   int delNews(int newsid);
		
}
