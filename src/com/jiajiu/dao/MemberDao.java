package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Member;

public interface MemberDao {

	/**
	 * 获取所有成员
	 * @return
	 */
	List<Member> queryMember();
	
	/**
	 * 后台添加一个成员
	 */
	
	
	boolean AddMember(Integer id,String name,String position ,String photo);
	
	
	boolean DelMember(int id);
	/**
	 * 查询一个成员
	 * @param id
	 * @return
	 */
	Member ObjMember(int id);
	
	int UpdateMember(int id,String name,String position,String photo);
}
