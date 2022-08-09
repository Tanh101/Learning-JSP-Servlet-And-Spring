package com.laptrinhjavaweb.service.impl;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
public class NewServive implements INewService {

	
	@Inject
	private INewDAO newDao;
	
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryid) {
		return newDao.findByCategoryId(categoryid);
	}


	@Override
	public NewModel save(NewModel newModel) {
		
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}


	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreateDate(oldNew.getCreateDate());
		updateNew.setCreatedby(oldNew.getCreatedby());
		newDao.Update(updateNew);
		return newDao.findOne(updateNew.getId());
	}
	
}
