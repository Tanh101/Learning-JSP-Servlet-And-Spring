package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
