package com.laptrinhjavaweb.model;

public class NewModel extends AbtractModel{
	private String title;
	private String thumnail;
	private String shortDescription;
	private String content;
	private Long categoryId;
	
	
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryid) {
		this.categoryId = categoryid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
