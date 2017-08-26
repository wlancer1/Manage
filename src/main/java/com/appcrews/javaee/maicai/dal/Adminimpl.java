package com.appcrews.javaee.maicai.dal;


import com.appcrews.javaee.maicai.model.base.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class Adminimpl implements Admin{
	@Autowired
	private BaseDaoI baseDaoI;
	@Override
	public int getLength() {
		String hql = "SELECT count(*) FROM AdminInfo";
		return  baseDaoI.count(hql);
	}



	@Override
	public AdminInfo getAdminInfo(String account) {
		String hql = "from AdminInfo  where account='"+account+"'";
		return (AdminInfo) baseDaoI.get(hql);
	}






}
