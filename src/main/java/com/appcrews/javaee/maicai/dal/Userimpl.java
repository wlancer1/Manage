package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Userimpl implements User {
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

	@Override
	public UserInfo getUserInfo(String account) {
		String hql="From UserInfo where name='"+account+"'";
		return (UserInfo) baseDaoI.get(hql);
	}
	//


	@Override
	public int count(int power) {
		String hql="select count(*) from UserInfo where power="+power;
		return baseDaoI.count(hql);
	}
}
