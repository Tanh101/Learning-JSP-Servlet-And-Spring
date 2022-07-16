package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO implements INewDAO {

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
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> result = new ArrayList<NewModel>();
		String sql = "SELECT * FROM category where categoryid = ?";
		Connection conn = getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				pre = conn.prepareStatement(sql);
				pre.setLong(0, categoryId);
				rs = pre.executeQuery();
				while (rs.next()) {
					NewModel news = new NewModel();
					news.setId(rs.getLong("id"));
					news.setTitle(rs.getString("title"));
					result.add(news);
				}
				if (conn != null) {
					conn.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
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
					e2.printStackTrace();
					return null;
				}
			}
		}
		return result;
	}
	
}
