package com.jiajiu.dao;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jiaju.entity.News;

public interface NewsDao {
	/**
	 * ͨ��news�б�typeid��������л�
	 * @param typeid
	 * @return
	 */
		List<News> queryNewsDao(int typeid); 
		/**
		 * ����������л�
		 * @param typeid
		 * @return
		 */
		
		List<News> queryNewsDaowucan(); 
		/**
		 * ɾ��һ����Ѷ
		 */
		boolean delnews(int newsid);
		
		
		int addNews(int typeid,String title,String content,String time);
	
	   int delNews(int newsid);
		
}
