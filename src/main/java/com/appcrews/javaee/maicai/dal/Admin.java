package com.appcrews.javaee.maicai.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.tool.MD5;

public class Admin extends JdbcDaoSupport {
	@SuppressWarnings({ "unchecked", "unused" })
	public int panduan(String account, String password) {
		List<AdminInfo> list = new ArrayList<AdminInfo>();
		String sql = "SELECT* FROM admin";
		list = this.getJdbcTemplate().query(sql, new adminrowMap());
		for (int i = 0; i < list.size(); i++) {

			String am = list.get(i).getAccount();
			String pm = list.get(i).getPassword();
			am = MD5.Encrypt(am, am.length());
			pm = MD5.Encrypt(pm, pm.length());
			if (am.equals(account) && pm.equals(password)) {
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
