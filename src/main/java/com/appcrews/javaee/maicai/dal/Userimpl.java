package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appcrews.javaee.maicai.model.UserInfo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;

public class Userimpl extends JdbcDaoSupport implements User{
	@SuppressWarnings("unchecked")
	public List<BuyerInfo> getlistb() {
		List<BuyerInfo> list = new ArrayList<BuyerInfo>();
		String sql = "SELECT* FROM buyer";
		list = this.getJdbcTemplate().query(sql, new BuyerrowMap());
		return list;

	}
@SuppressWarnings("unchecked")
public List<SaleInfo> getlists(){
	List<SaleInfo> list = new ArrayList<SaleInfo>();
	String sql="SELECT* FROM saler";
	list=this.getJdbcTemplate().query(sql, new SalerowMap());
	return list;
	
}
public int size(){
	String sql1="SELECT COUNT(*) FROM saler";
	String sql2="SELECT COUNT(*) FROM buyer";
	int size=this.getJdbcTemplate().queryForInt(sql1)+this.getJdbcTemplate().queryForInt(sql2);
	return size;
	
}
public SaleInfo getsaleinfo(int index){
	String sql="SELECT* FROM saler WHERE ID ='"+index+"'";
	SaleInfo info= (SaleInfo) this.getJdbcTemplate().queryForObject(sql, new SalerowMap());
	return info;
	
}
public BuyerInfo getbuyinfo(int index){
	String sql="SELECT* FROM buyer WHERE ID ='"+index+"'";
	return (BuyerInfo) this.getJdbcTemplate().queryForObject(sql, new BuyerrowMap());
	
}

	@Override
	public void update(UserInfo userInfo) {
	String sql;
	if(userInfo.getId()<2000000)
		sql="UPDATE saler SET username = '"+userInfo.getName()+"', email = '"+userInfo.getEmail()+"',tele= '"+ userInfo.getPhone()+"' WHERE ID = '"+userInfo.getId()+"'";
	else
		sql="UPDATE buyer SET bname = '"+userInfo.getName()+"', email = '"+userInfo.getEmail()+"',btele= '"+ userInfo.getPhone()+"' WHERE ID = '"+userInfo.getId()+"'";
		this.getJdbcTemplate().update(sql);
	}

	@Override
	public void insert(BuyerInfo buyerInfo) {
		String sql = "insert into buyer(bname,bpassword, btele, baddress, bremark, email) values ";
		sql = sql + " ('" + buyerInfo.getBname() + "','" + buyerInfo.getPassword()+ "','"
				+ buyerInfo.getBtele() + "','" + buyerInfo.getBaddress() + "','"
				+ buyerInfo.getBremark() +"','" + buyerInfo.getBemail() + "','"+ "')";
		this.getJdbcTemplate().execute(sql);
}

	@Override
	public void insert(int index) {
		String sql;
		if(index<2000000)
		{
			sql = "insert into buyer(bname, bpassword, btele, baddress, email) ";
			sql=sql+"select username, password, tele, saddress, email from saler Where ID="+index;
		}
		else{
			 sql = "insert into saler(username, password, tele, saddress, email )";
			sql=sql+"select bname, bpassword, btele, baddress, email from buyer Where ID="+index;
		}
		System.out.println("======"+sql);
		this.getJdbcTemplate().execute(sql);
	}

	@Override
	public void insert(SaleInfo saleInfo) {
		String sql = "insert into saler(username`, `password`, `email`, `saddress`, `tele``) values ";
		sql = sql + " ('" + saleInfo.getUsername() + "','" + saleInfo.getPassword()+ "','"
				+ saleInfo.getEmail() + "','" + saleInfo.getSaddress() + "','"
				+ saleInfo.getTele() + "')";
		this.getJdbcTemplate().execute(sql);
	}

	@Override
	public void delete(int index) {
	String sql;
	if(index<2000000)
			sql="delete from saler where ID ="+index+"";
		else
			sql="delete from buyer where ID ="+index+"";
		this.getJdbcTemplate().execute(sql);
	}

	public class SalerowMap implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		SaleInfo info = new SaleInfo();
		info.setEmail(rs.getString("email"));
		info.setUserid(rs.getInt("ID"));
		info.setUsername(rs.getString("username"));
		info.setPower(rs.getInt("power"));
		info.setTele(rs.getInt("tele"));
		info.setStatus(rs.getInt("status"));
		info.setSaddress(rs.getString("saddress"));
		return info;
	}

}
	public class BuyerrowMap implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			BuyerInfo info = new BuyerInfo();
			info.setBaddress(rs.getString("baddress"));
			info.setBname(rs.getString("bname"));
			info.setBtele(rs.getInt("btele"));
			info.setId(rs.getInt("ID"));
			info.setStatus(rs.getInt("status"));
			info.setBemail(rs.getString("email"));
			info.setBremark(rs.getString("bremark"));
			info.setPower(rs.getInt("power"));
			return info;
		}

	}
}
