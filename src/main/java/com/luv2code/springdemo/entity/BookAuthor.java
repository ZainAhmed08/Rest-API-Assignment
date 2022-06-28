package com.luv2code.springdemo.entity;

public class BookAuthor {

	private String bookId;
	private String bookName;
	private String bookPrice;
	private String journal;

	private String authorName;

	
	public BookAuthor() {
		
	}


	public BookAuthor(String bookId, String bookName, String bookPrice, String journal, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.journal = journal;
		this.authorName = authorName;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}


	public String getJournal() {
		return journal;
	}


	public void setJournal(String journal) {
		this.journal = journal;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
}
