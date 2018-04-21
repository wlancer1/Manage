package com.appcrews.javaee.maicai.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
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
		String hql = "from DetailInfo WHERE onum ='" + ounm + "'";
		return baseDaoI.find(hql);
	}
	public void deleteDetail(int onum,int wareid){
		String hql="delete DetailInfo WHERE onum = '"+onum+"' AND wareid = '"+wareid+"'";
		baseDaoI.executeHql(hql);
	}

	@Override
	public List<OrderInfo> queryUid(int uid) {
		String hql="from OrderInfo  WHERE uid ="+uid;
		return baseDaoI.find(hql);
	}

	@Override
	public  List<OrderInfo> queryOnum(String onum) {
		String hql="from OrderInfo o,DetailInfo d,WareInfo w WHERE o.onum="+onum+"AND o.onum=d.onum AND w.fid=d.wareid";
//		String hql="from OrderInfo o,De WHERE o.onum="+onum;
		return baseDaoI.find(hql);
	}
}
