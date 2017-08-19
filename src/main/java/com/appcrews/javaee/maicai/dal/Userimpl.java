package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appcrews.javaee.maicai.model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class Userimpl implements User{
	@Autowired
	private BaseDaoI baseDaoI;
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

	public List<BuyerInfo> getlistb() {
		String hql = "FROM BuyerInfo";
		return baseDaoI.find(hql);

	}
@SuppressWarnings("unchecked")
public List<SaleInfo> getlists(){
	String hql="FROM SaleInfo";
	return baseDaoI.find(hql);
	
}
public int getLength(){
	String hql1="SELECT COUNT(*) FROM BuyerInfo";
	String hql2="SELECT COUNT(*) FROM SaleInfo";
	return baseDaoI.count(hql1)+baseDaoI.count(hql2);
	
}
//public SaleInfo getsaleinfo(int index){
//	String sql="SELECT* FROM saler WHERE ID ='"+index+"'";
//	SaleInfo info= (SaleInfo) this.getJdbcTemplate().queryForObject(sql, new SalerowMap());
//	return info;
//
//}
//public BuyerInfo getbuyinfo(int index){
//	String sql="SELECT* FROM buyer WHERE ID ='"+index+"'";
//	return (BuyerInfo) this.getJdbcTemplate().queryForObject(sql, new BuyerrowMap());
//
//}

//	@Override
//	public void update(UserInfo userInfo) {
//	String sql;
//	if(userInfo.getId()<2000000)
//		sql="UPDATE saler SET username = '"+userInfo.getName()+"', email = '"+userInfo.getEmail()+"',tele= '"+ userInfo.getPhone()+"' WHERE ID = '"+userInfo.getId()+"'";
//	else
//		sql="UPDATE buyer SET bname = '"+userInfo.getName()+"', email = '"+userInfo.getEmail()+"',btele= '"+ userInfo.getPhone()+"' WHERE ID = '"+userInfo.getId()+"'";
//		this.getJdbcTemplate().update(sql);
//	}
//
//	@Override
//	public void insert(BuyerInfo buyerInfo) {
//		String sql = "insert into buyer(bname,bpassword, btele, baddress, bremark, email) values ";
//		sql = sql + " ('" + buyerInfo.getBname() + "','" + buyerInfo.getPassword()+ "','"
//				+ buyerInfo.getBtele() + "','" + buyerInfo.getBaddress() + "','"
//				+ buyerInfo.getBremark() +"','" + buyerInfo.getBemail() + "','"+ "')";
//		this.getJdbcTemplate().execute(sql);
//}
//
//	@Override
//	public void insert(int index) {
//		String sql;
//		if(index<2000000)
//		{
//			sql = "insert into buyer(bname, bpassword, btele, baddress, email) ";
//			sql=sql+"select username, password, tele, saddress, email from saler Where ID="+index;
//		}
//		else{
//			 sql = "insert into saler(username, password, tele, saddress, email )";
//			sql=sql+"select bname, bpassword, btele, baddress, email from buyer Where ID="+index;
//		}
//		System.out.println("======"+sql);
//		getCurrentSession().createSQLQuery(sql).executeUpdate();
//	}

//	@Override
//	public void insert(SaleInfo saleInfo) {
//		String sql = "insert into saler(username`, `password`, `email`, `saddress`, `tele``) values ";
//		sql = sql + " ('" + saleInfo.getUsername() + "','" + saleInfo.getPassword()+ "','"
//				+ saleInfo.getEmail() + "','" + saleInfo.getSaddress() + "','"
//				+ saleInfo.getTele() + "')";
//		this.getJdbcTemplate().execute(sql);
//	}
//

	@Override
	public void delete(int index) {
		String sql;
//		if(index<2000000)
//		{
//			sql = "insert into buyer(bname, bpassword, btele, baddress, email) ";
//			sql=sql+"select username, password, tele, saddress, email from saler Where ID="+index;
//		}
//		else{
//			sql = "insert into saler(username, password, tele, saddress, email )";
//			sql=sql+"select bname, bpassword, btele, baddress, email from buyer Where ID="+index;
//		}
//		System.out.println("======"+sql);
//		getCurrentSession().createSQLQuery(sql).executeUpdate();
//		System.out.println("======"+sql);
		if(index<2000000)
			sql="delete from saler where ID ="+index+"";
		else
			sql="delete from buyer where ID ="+index+"";
		getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

//	@Override
//	public void delete(int index) {
//	String sql;
//	if(index<2000000)
//			sql="delete from saler where ID ="+index+"";
//		else
//			sql="delete from buyer where ID ="+index+"";
//		getCurrentSession().createSQLQuery(sql).executeUpdate();
//	}
//
//	public class SalerowMap implements RowMapper {
//
//	@Override
//	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//		// TODO Auto-generated method stub
//		SaleInfo info = new SaleInfo();
//		info.setEmail(rs.getString("email"));
//		info.setUserid(rs.getInt("ID"));
//		info.setUsername(rs.getString("username"));
//		info.setPower(rs.getInt("power"));
//		info.setTele(rs.getInt("tele"));
//		info.setStatus(rs.getInt("status"));
//		info.setSaddress(rs.getString("saddress"));
//		return info;
//	}

//}
//	public class BuyerrowMap implements RowMapper {
//
//		@Override
//		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			BuyerInfo info = new BuyerInfo();
//			info.setBaddress(rs.getString("baddress"));
//			info.setBname(rs.getString("bname"));
//			info.setBtele(rs.getInt("btele"));
//			info.setId(rs.getInt("ID"));
//			info.setStatus(rs.getInt("status"));
//			info.setBemail(rs.getString("email"));
//			info.setBremark(rs.getString("bremark"));
//			info.setPower(rs.getInt("power"));
//			return info;
//		}
//
//	}
}
