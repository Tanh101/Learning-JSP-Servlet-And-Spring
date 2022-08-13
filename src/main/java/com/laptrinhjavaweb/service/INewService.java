package com.laptrinhjavaweb.service;
import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryid); 
	NewModel save(NewModel newModel);
	NewModel  update(NewModel updateNew);
	void delete(long[] ids);
}
