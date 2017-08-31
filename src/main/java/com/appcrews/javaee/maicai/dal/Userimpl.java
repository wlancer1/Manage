package com.appcrews.javaee.maicai.dal;

import java.util.List;

import com.appcrews.javaee.maicai.model.base.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class Userimpl implements User{
	@Autowired
	private BaseDaoI baseDaoI;

	@Override
	public List<UserInfo> getListUser() {
		String hql = "FROM UserInfo";
		return baseDaoI.find(hql);
	}

	@Override
	public List<UserInfo> getListUser(int pageNo, int pageSize) {
		String hql = "FROM UserInfo";
		return baseDaoI.find(hql,pageNo,pageSize);
	}





//




}
