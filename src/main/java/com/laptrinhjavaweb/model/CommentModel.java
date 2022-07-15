package com.laptrinhjavaweb.model;

public class CommentModel extends AbtractModel {
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private Long newId;
	private Long userId;
}
