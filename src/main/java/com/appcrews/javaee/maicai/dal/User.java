package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;

public class User extends JdbcDaoSupport {
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
	String sql="SELECT* FROM saler WHERE userID ='"+index+"'";
	SaleInfo info= (SaleInfo) this.getJdbcTemplate().queryForObject(sql, new SalerowMap());
	return info;
	
}
public BuyerInfo getbuyinfo(int index){
	String sql="SELECT* FROM buyer WHERE ID ='"+index+"'";
	return (BuyerInfo) this.getJdbcTemplate().queryForObject(sql, new BuyerrowMap());
	
}
public class SalerowMap implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		SaleInfo info = new SaleInfo();
		info.setEmail(rs.getString("email"));
		info.setUserid(rs.getInt("userID"));
		info.setUsername(rs.getString("username"));
		info.setPower("卖家");
		info.setTele(rs.getInt("tele"));
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
			info.setNumber(rs.getInt("btele"));
			info.setId(rs.getInt("ID"));
			info.setBemail(rs.getString("email"));
			info.setBremark(rs.getString("bremark"));
			info.setPower("买家");
			return info;
		}

	}
}
