package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import org.springframework.stereotype.Repository;

@Repository
public class Orderimpl implements Order {
	@Autowired
	BaseDaoI baseDaoI;
	@SuppressWarnings("unchecked")
//	public List<OrderInfo> getList(int index) {
//		List<OrderInfo> list = new ArrayList<OrderInfo>();
//		String sql = "SELECT* FROM order1 LIMIT " + index + ",5";
//		list = this.getJdbcTemplate().query(sql, new orderrowMap());
//		return list;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<OrderInfo> getListorder() {
//		List<OrderInfo> list = new ArrayList<OrderInfo>();
//		String sql = "SELECT* FROM order1";
//		list = this.getJdbcTemplate().query(sql, new orderrowMap());
//		return list;
//	}
//
//	public void update(int number, int SCid, int onum, int index) {
//		int YSCid = 0;
//		ArrayList<Integer> SCYid = new ArrayList<>();
//		List<DetailInfo> a = getListdetailorder(onum);
//		for (int i = 0; i < a.size(); i++) {
//			SCYid.add(a.get(i).getSCid());
//		}
//		YSCid = SCYid.get(index);
//		String sql = "UPDATE detailorder SET SCid = '" + SCid
//				+ "' ,`SCnum` = '" + number + "' WHERE onum = '" + onum
//				+ "' AND SCid = '" + YSCid + "'";
//		this.getJdbcTemplate().execute(sql);
//	}
//
//	public OrderInfo getOrderInfo(int id) {
//		String sql = "select * from order1 where onum=" + id + "";
//		System.out.println(sql);
//		OrderInfo info = (OrderInfo) this.getJdbcTemplate().queryForObject(sql,
//				new orderrowMap());
//		return info;
//
//	}
//

	@Override
	public List<DetailInfo> getListdetailorder(int ounm) {
		String hql="from DetailInfo WHERE onum ='"+ounm+"'";
		return baseDaoI.find(hql);
	}
	@Override
	public List<OrderInfo> getListOrder(int pageNo, int pageSize) {
		String hql="from OrderInfo";
		return baseDaoI.find(hql,pageNo,pageSize);
	}

	@Override
	public List<OrderInfo> getListOrder() {
		String hql="from OrderInfo";
		return baseDaoI.find(hql);
	}

	@Override
	public int count(int index) {
		String hql;
		if(index<2000000)
		hql="select count(*) from OrderInfo where salerID ='"+index+"'";
		else
			hql="select count(*) from OrderInfo where buyerID ='"+index+"'";
			return baseDaoI.count(hql);
	}

//
//	@SuppressWarnings("unchecked")
//	public List<DetailInfo> getListdetailorder(int ounm) {
//		List<DetailInfo> list = new ArrayList<DetailInfo>();
//		String sql = "SELECT * FROM detailorder WHERE onum ='" + ounm + "'";
//		list = this.getJdbcTemplate().query(sql, new detialrowMap());
//		return list;
//	}
//
//	public void delete(int id, String onum) {
//		String sql = "DELETE FROM detailorder WHERE onum = '" + onum
//				+ "' AND SCid = '" + id + "' ";
//		this.getJdbcTemplate().execute(sql);
//	}
//
//	public void deleteorder(String onum) {
//		String sql = "DELETE FROM order1  WHERE onum = '" + onum + "' ";
//		this.getJdbcTemplate().execute(sql);
//	}
//
//	public class orderrowMap implements RowMapper {
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			OrderInfo info = new OrderInfo();
//			info.setBuyerID(rs.getInt("buyerID"));
//			info.setUserID(rs.getInt("salerID"));
//			info.setOnum(rs.getInt("onum"));
//			info.setOremark(rs.getString("oremark"));
//			info.setStime(rs.getTimestamp("Stime"));
//			info.setOtime(rs.getTimestamp("otime"));
//
//			return info;
//		}
//	}
//		public count(){
//
//		}
	@Override
	public int getLength() {
		String hql="SELECT COUNT(*) FROM OrderInfo";
		return baseDaoI.count(hql);
	}



}
