package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet rs) {
		NewModel news = new NewModel();
		try {
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdesscription"));
			news.setCreateDate(rs.getTimestamp("createdDate"));
			news.setCreatedby(rs.getString("createBy"));
			if(rs.getTimestamp("modifiedDate") != null) {
				news.setModifiedDate(rs.getTimestamp("modifiedDate"));
			}
			if(rs.getString("modifiedBy") != null) {
				news.setModifiedby(rs.getString("modifiedBy"));
			}
			return news;
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
}
