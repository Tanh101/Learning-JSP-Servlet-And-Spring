package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId); 
	Long save(NewModel newModel);
	void Update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll();
}
