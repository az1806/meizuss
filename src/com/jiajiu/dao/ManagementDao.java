package com.jiajiu.dao;

import java.util.ArrayList;

import com.jiaju.entity.Management;

public interface ManagementDao {
/**
 * ����һ��������
 * @param name
 * @param possword
 * @return
 */
	boolean insertMage(String name,String password);
	
	/**
	 * �������й�����
	 * @return
	 */
	ArrayList<Management> selectMage();
	
	
	/**
	 * ����һ����¼������
	 */
	
	Management selectMageByBame(String username);

	
	
}
