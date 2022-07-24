package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.NewModel;

public class AbtractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demoservlet";
			Connection conn = DriverManager.getConnection(url, "root", "606902");
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pre = conn.prepareStatement(sql);
			setParameter(pre, parameters);
			rs = pre.executeQuery();
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				return null;
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement pre, Object... parameters) {

		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					pre.setLong(index, (Long) (parameter));
				}else if(parameter instanceof String) {
					pre.setString(index, (String) parameter);
				}else if(parameter instanceof Integer) {
					pre.setInt(index, (int) parameter);
				}else if(parameter instanceof Boolean) {
					pre.setBoolean(index, (boolean) parameter);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
