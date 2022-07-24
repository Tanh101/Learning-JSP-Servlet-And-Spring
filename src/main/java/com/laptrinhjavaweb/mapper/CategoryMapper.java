package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.util.Locale.Category;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(rs.getLong("id"));
			category.setCode(rs.getString("code"));
			category.setName(rs.getString("name"));
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
}
