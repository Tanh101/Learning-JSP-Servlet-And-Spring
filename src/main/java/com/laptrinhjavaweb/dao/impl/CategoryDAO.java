package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.mysql.cj.jdbc.Driver;

public class CategoryDAO implements ICategoryDAO {

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
	public List<CategoryModel> findAll() {
		List<CategoryModel> result = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM category";
		Connection conn = getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				pre = conn.prepareStatement(sql);
				rs = pre.executeQuery();
				while (rs.next()) {
					CategoryModel category = new CategoryModel();
					category.setId(rs.getLong("id"));
					category.setCode(rs.getString("code"));
					category.setName(rs.getString("name"));
					result.add(category);
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
//	public static void main(String[] args) throws SQLException {
//		Connection c = new CategoryDAO().getConnection();
////		System.out.println(c.getCatalog().toString());
//	}
}
