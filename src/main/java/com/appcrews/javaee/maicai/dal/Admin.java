package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.AdminInfo;

public class Admin extends JdbcDaoSupport {
	@SuppressWarnings({ "unchecked", "unused" })
	public int panduan(String account, String password) {
		List<AdminInfo> list = new ArrayList<AdminInfo>();
		String sql = "SELECT* FROM admin";
		list = this.getJdbcTemplate().query(sql, new adminrowMap());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccount().equals(account)
					&& list.get(i).getPassword().equals(password)) {
				return list.get(i).getPower();
			} 
		}
		return -1;
	}
	
	public class adminrowMap implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			AdminInfo info = new AdminInfo();
			info.setAccount(rs.getString("account"));
			info.setPassword(rs.getString("password"));
			info.setPower(rs.getInt("power"));
			return info;
		}

	}

}
