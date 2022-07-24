package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbtractDAO<NewModel> implements INewDAO {

	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> result = new ArrayList<NewModel>();
		String sql = "SELECT * FROM news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO news (title, content, categoryid) VALUES(?, ?, ?)";
		return null;
	}
	
}
