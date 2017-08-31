package com.appcrews.javaee.maicai.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;
import org.springframework.stereotype.Repository;

@Repository
public class Dataimpl implements Data {
	@Autowired
	BaseDaoI baseDaoI;
//	@Override
//	public int delete(int id) {
//		String sql="DELETE FROM ware  WHERE fId = '" + id + "' ";
//		return baseDaoI.exexuteSql(sql);
//	}

//	@Override
//	public List<WareInfo> getListWare(int pageNo, int pageSize) {
//		String hql="from WareInfo";
//		return baseDaoI.find(hql,pageNo,pageSize);
//	}
//
//	@Override
//	public List<WareInfo> getListWare(int pageNo, int pageSize,int flag) {
//		String hql="from WareInfo ";
//		if (flag == 0) {
//			hql+="order by price desc";
//			return baseDaoI.find(hql,pageNo,pageSize);
//		} else {
//			hql+="order by price asc";
//			return baseDaoI.find(hql,pageNo,pageSize);
//		}
//	}
//
//	@Override
//	public List<WareInfo> getListWare(String key) {
//		String hql="from WareInfo WHERE name ='"+key+"'";
//		return baseDaoI.find(hql);
//	}



	@Override
	public List<TypeInfo> getListType() {
		String hql="from TypeInfo";
	return baseDaoI.find(hql);
	}


	@Override
	public int getLength() {
		String hql="SELECT COUNT(*) FROM WareInfo";
		return baseDaoI.count(hql);
	}
}
