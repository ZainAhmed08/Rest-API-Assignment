package com.luv2code.springdemo.entity;

public class AuthorBook {

	private String authorName;
	private int experience;
	
	public AuthorBook() {
		
	}

	public AuthorBook(String authorName, int experience) {
		super();
		this.authorName = authorName;
		this.experience = experience;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
