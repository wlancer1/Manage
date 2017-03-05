package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Size2DSyntax;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.ShucaiInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

public class Dataimpl extends JdbcDaoSupport implements Data{

	@SuppressWarnings("unchecked")
	public List<ShucaiInfo> getList(int index) {
		List<ShucaiInfo> list = new ArrayList<ShucaiInfo>();
		String sql = "SELECT* FROM shucai LIMIT " + index + ",5";
		list = this.getJdbcTemplate().query(sql, new ShuCairowMap());
		return list;
	}
	@SuppressWarnings( "unchecked")
	public List<ShucaiInfo> getListsearch(String key){
		List<ShucaiInfo> list = new ArrayList<ShucaiInfo>();
		String sql="SELECT * FROM shucai WHERE fName LIKE '%"+key+"%'LIMIT 0,5";
		list=this.getJdbcTemplate().query(sql, new ShuCairowMap());
		return list;
		
	}

	@SuppressWarnings("unchecked")
	public List<ShucaiInfo> getListsort(String name) {
		List<ShucaiInfo> list = new ArrayList<ShucaiInfo>();
		String sql = "SELECT * FROM `shucai` ORDER BY (CASE WHEN fName='"
				+ name + "' THEN 1 ELSE 4 END),fName DESC";
		list = this.getJdbcTemplate().query(sql, new ShuCairowMap());
		return list;
	}

	public ShucaiInfo getShucaiInfo(int id) {
		String sql = "select * from shucai where fId=" + id + "";
		System.out.println(sql);
		ShucaiInfo info = (ShucaiInfo) this.getJdbcTemplate().queryForObject(
				sql, new ShuCairowMap());
		return info;

	}

	@SuppressWarnings("unchecked")
	public List<ShucaiInfo>  getListshucaisort(int index, int flag,int pageSize) {
		List<ShucaiInfo> list = new ArrayList<ShucaiInfo>();
		if (flag == 0) {
			String sql1 = "SELECT* FROM shucai ORDER BY fPrice DESC LIMIT "
					+ index + ","+pageSize+ "";
//			String sql1 = "SELECT* FROM shucai ORDER BY fPrice DESC ";
			list = this.getJdbcTemplate().query(sql1, new ShuCairowMap());
		} else {
			String sql2 = "SELECT* FROM shucai ORDER BY fPrice asc LIMIT "
					+ index + ","+pageSize+ "";
//			String sql2 = "SELECT* FROM shucai ORDER BY fPrice asc ";
			list = this.getJdbcTemplate().query(sql2, new ShuCairowMap());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ShucaiInfo> getListshucai() {
		List<ShucaiInfo> list = new ArrayList<ShucaiInfo>();
		String sql = "SELECT* FROM shucai";
		list = this.getJdbcTemplate().query(sql, new ShuCairowMap());
		return list;
	}

	public int getSCid(String name) {
		String sql = "SELECT fId FROM shucai WHERE fName = '" + name + "'";
		return this.getJdbcTemplate().queryForInt(sql);

	}

	@SuppressWarnings("unchecked")
	public List<TypeInfo> getType(String TYPE) {
		List<TypeInfo> list = new ArrayList<TypeInfo>();
		String sql = "SELECT * FROM `type` ORDER BY (CASE WHEN fType='" + TYPE
				+ "' THEN 1 ELSE 4 END),fType DESC;";
		list = this.getJdbcTemplate().query(sql, new TyperowMap());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TypeInfo> gettype() {
		List<TypeInfo> list = new ArrayList<TypeInfo>();
		String sql = "SELECT * FROM type";
		list = this.getJdbcTemplate().query(sql, new TyperowMap());
		return list;
	}
	
	public void inserttype(String type) {
		String sql = "INSERT INTO `shujub`.`type` (`fType`, `t-remark`) VALUES ";
		sql=sql+" ('"+type+  "','"+"1"+"')";
		this.getJdbcTemplate().execute(sql);
		
	}
	public void insert(ShucaiInfo info) {
		String sql = "insert into shucai(fName,fPrice,fImg,fType,fRemark) values ";
		sql = sql + " ('" + info.getName() + "','" + info.getPrice() + "','"
				+ info.getImg() + "','" + info.getType() + "','"
				+ info.getRemark() + "')";
		this.getJdbcTemplate().execute(sql);
	}

	public void update(int id, ShucaiInfo info) throws SQLException {
		String sql = "update shucai set" + " fName='" + info.getName()
				+ "',fPrice='" + info.getPrice() + "',fImg='" + info.getImg()
				+ "',fType='" + info.getType() + "',fRemark='"
				+ info.getRemark() + "' where fid=" + id + "";
		this.getJdbcTemplate().execute(sql);

	}


	public String delete(int id) throws SQLException {
		try {
			String sql = "delete from shucai where fId =" + id + "";
			this.getJdbcTemplate().execute(sql);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}

	}

	public class ShuCairowMap implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			ShucaiInfo info = new ShucaiInfo();
			info.setId(rs.getInt("fId"));
			info.setName(rs.getString("fName"));
			info.setPrice(rs.getFloat(("fPrice")));
			info.setImg(rs.getString("fImg"));
			info.setType(rs.getString("fType"));
			info.setRemark(rs.getString("fRemark"));
			return info;
		}

	}

	public class TyperowMap implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			TypeInfo info = new TypeInfo();
			info.setRemark(rs.getString("t-remark"));
			info.setType(rs.getString("fType"));
			return info;
		}

	}
}
