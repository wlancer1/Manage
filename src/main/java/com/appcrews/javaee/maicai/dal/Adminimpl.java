package com.appcrews.javaee.maicai.dal;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.appcrews.javaee.maicai.model.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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
//		String sql="SELECT * from admin WHERE account='"+account+"'";

//		Query query= getCurrentSession().createQuery(hql);
		return (AdminInfo) baseDaoI.get(hql);
	}






}
