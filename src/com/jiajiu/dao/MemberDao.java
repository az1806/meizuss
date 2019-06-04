package com.jiajiu.dao;

import java.util.List;

import com.jiaju.entity.Member;

public interface MemberDao {

	/**
	 * ��ȡ���г�Ա
	 * @return
	 */
	List<Member> queryMember();
	
	/**
	 * ��̨���һ����Ա
	 */
	
	
	boolean AddMember(Integer id,String name,String position ,String photo);
	
	
	boolean DelMember(int id);
	/**
	 * ��ѯһ����Ա
	 * @param id
	 * @return
	 */
	Member ObjMember(int id);
	
	int UpdateMember(int id,String name,String position,String photo);
}
