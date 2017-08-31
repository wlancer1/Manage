package com.appcrews.javaee.maicai.dal;


import com.appcrews.javaee.maicai.model.base.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class Adminimpl implements Admin{
	@Autowired
	private BaseDaoI baseDaoI;

	@Override
	public List<Integer> getSizeList() {
		String hql = "SELECT count(*) FROM UserInfo";
		List<Integer> sizeList=new ArrayList<>();
		sizeList.add(baseDaoI.count(hql));
		hql = "SELECT count(*) FROM WareInfo";
		sizeList.add(baseDaoI.count(hql));
		hql = "SELECT count(*) FROM OrderInfo";
		sizeList.add(baseDaoI.count(hql));
		return  sizeList;
	}

	@Override
	public AdminInfo getAdminInfo(String account) {
		String hql = "from AdminInfo  where account='"+account+"'";
		return (AdminInfo) baseDaoI.get(hql);
	}






}
