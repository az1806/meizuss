package com.jiajiu.dao;

import com.jiaju.entity.Company;

public interface CompanyDao {

	
	Company queryCompany();
	/**
	 * 修改公司信息
	 * @param id
	 * @param companyname
	 * @param syjs
	 * @param gyjs
	 * @param culture
	 * @param address
	 * @param email
	 * @param contact
	 * @param imgzong
	 * @param www
	 * @return
	 */
	int updateCompany(int id,String companyname,String syjs,String gyjs,String culture,String address,String email,String contact,String imgzong,String www,String logo);
	
	//返回参数，值
}
