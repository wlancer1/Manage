package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class Dataimpl implements Data {
	@Autowired
	BaseDaoI baseDaoI;
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}


	@Override
	public int delete(int id) {
		String sql="DELETE FROM ware  WHERE fId = '" + id + "' ";
		return getCurrentSession().createSQLQuery(sql).executeUpdate();

	}

	@Override
	public List<WareInfo> getListWare(int pageNo, int pageSize) {
		String hql="from WareInfo";
		return baseDaoI.find(hql,pageNo,pageSize);
	}

	@Override
	public List<WareInfo> getListWare(int pageNo, int pageSize,int flag) {
		String hql="from WareInfo ";
		if (flag == 0) {
			hql+="order by price desc";
			return baseDaoI.find(hql,pageNo,pageSize);
		} else {
			hql+="order by price asc";
			return baseDaoI.find(hql,pageNo,pageSize);
		}
	}

	@Override
	public List<WareInfo> getListWare(String key) {
		String hql="from WareInfo WHERE name ='"+key+"'";
		return baseDaoI.find(hql);
	}

	//	@SuppressWarnings("unchecked")
//	public List<WareInfo>  getListshucaisort(int index, int flag, int pageSize) {
//		List<WareInfo> list = new ArrayList<WareInfo>();
//		if (flag == 0) {
//			String sql1 = "SELECT* FROM shucai ORDER BY fPrice DESC LIMIT "
//					+ index + ","+pageSize+ "";
////			String sql1 = "SELECT* FROM shucai ORDER BY fPrice DESC ";
//
//			list = this.getJdbcTemplate().query(sql1, new ShuCairowMap());
//		} else {
//			String sql2 = "SELECT* FROM shucai ORDER BY fPrice asc LIMIT "
//					+ index + ","+pageSize+ "";
////			String sql2 = "SELECT* FROM shucai ORDER BY fPrice asc ";
//			list = this.getJdbcTemplate().query(sql2, new ShuCairowMap());
//		}
//		return list;
//
//
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<WareInfo> getListshucai() {
//		List<WareInfo> list = new ArrayList<WareInfo>();
//		String sql = "SELECT* FROM shucai";
//		list = this.getJdbcTemplate().query(sql, new ShuCairowMap());
//		return list;
//	}
//
//	public int getSCid(String name) {
//		String sql = "SELECT fId FROM shucai WHERE fName = '" + name + "'";
//		return this.getJdbcTemplate().queryForInt(sql);
//
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<TypeInfo> getType(String TYPE) {
//		List<TypeInfo> list = new ArrayList<TypeInfo>();
//		String sql = "SELECT * FROM `type` ORDER BY (CASE WHEN fType='" + TYPE
//				+ "' THEN 1 ELSE 4 END),fType DESC;";
//		list = this.getJdbcTemplate().query(sql, new TyperowMap());
//		return list;
//	}


	@Override
	public int getLength() {
		String hql="SELECT COUNT(*) FROM WareInfo";
		return baseDaoI.count(hql);
	}
}
