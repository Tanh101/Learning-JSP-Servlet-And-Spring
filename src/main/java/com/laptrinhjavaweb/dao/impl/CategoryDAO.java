package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.mysql.cj.jdbc.Driver;

public class CategoryDAO extends AbtractDAO<CategoryModel> implements ICategoryDAO {

	

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> result = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());

	}
//	public static void main(String[] args) throws SQLException {
//		Connection c = new CategoryDAO().getConnection();
////		System.out.println(c.getCatalog().toString());
//	}
}
