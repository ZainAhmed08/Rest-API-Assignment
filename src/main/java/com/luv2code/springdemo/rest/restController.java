package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Author;
import com.luv2code.springdemo.entity.Book;
import com.luv2code.springdemo.entity.BookAuthor;

@RestController
@RequestMapping("/api")
public class restController {

	private List<Book> theBooks;
	private List<Author> theAuthors;
	private BookAuthor temp;
	
	@PostConstruct
	public void loadData() {
		
		theBooks   = new ArrayList<Book>();
		theAuthors = new ArrayList<Author>();
		
		Author a1 = new Author(1,"zain ahmed",13);
		Book b1 = new Book("1","corejava","1200","book about java",a1);
		
		Author a2 = new Author(2,"ayesha ahmed",10);
		Book b2 = new Book("2","advancedjava","120","book about advanced java",a2);
		
		Author a3 = new Author(3,"farhan ahmed",33);
		Book b3 = new Book("3","html","200","book about html java",a3);

		theBooks.add(b1);
		theBooks.add(b2);
		theBooks.add(b3);
		
		theAuthors.add(a1);
		theAuthors.add(a2);
		theAuthors.add(a3);
	}
	
	@GetMapping("/books")
	public List<Book> getBook(){				
		return theBooks;
	}
	
	@GetMapping("/authors")
	public List<Author> getAuthor(){				
		return theAuthors;
	}
	
	// define endpoint for "/students/{studentId}" -return student at index
	@GetMapping("/books/{bookId}")
	public Book getStudent(@PathVariable int bookId) {
		
		//just index into the list ... keep it simple for now
		
		return theBooks.get(bookId);
	}
	
	@GetMapping("/authors/{authorId}")
	public Author getAuthor(@PathVariable int authorId) {
		
		//just index into the list ... keep it simple for now
		
		return theAuthors.get(authorId);
	}

	// post book current 
	@PostMapping("/books")
	public Book addStudent(@RequestBody BookAuthor theBookAuthors) {  
		Author author = null;
		boolean bookExists   = false;
		boolean authorExists = false;
		for(int i = 0 ; i < theBooks.size() ; i++) {
			if(theBooks.get(i).getBookName().equals(theBookAuthors.getBookName())) {
				bookExists = true;
				System.out.println(theBooks.get(i).getBookName()+" = "+theBookAuthors.getBookName());
				if(theBookAuthors.getAuthorName().equals(theBooks.get(i).getBookAuthor().getAuthorName())) {
					System.out.println(theBookAuthors.getAuthorName()+" = "+theBooks.get(i).getBookAuthor().getAuthorName());
					author = theBooks.get(i).getBookAuthor();
					authorExists = true;
					break;
				}
			}
		}
		if(bookExists == false) {
		for(int i = 0 ; i < theAuthors.size() ; i++) {
			if(theBookAuthors.getAuthorName().equals(theAuthors.get(i).getAuthorName())){
				authorExists = true;
				author = theAuthors.get(i);
				break;
			}
		}
		}
		System.out.println("bookExists: "+ bookExists + "  authorExists :"+ authorExists);
		if(bookExists && authorExists) {
			// throw an exception here if book with the same author exists...
			theBookAuthors.setAuthorName("already exists");
			theBookAuthors.setBookName("alreay exists");
			return null;
		}
		else if(bookExists == false && authorExists == false) {
			// throw a author not found exception
			return null;
		}
		else {
			Book result = new Book(String.valueOf(theBooks.size()+1),theBookAuthors.getBookName(),theBookAuthors.getBookPrice(),theBookAuthors.getJournal(),author);
			theBooks.add(result);
			return result;
		}
	}
	
	// add mapping for POST /book  -add new book
//		@PostMapping("/books")
//		public Book addStudent(@RequestBody BookAuthor theBookAuthors) {  
//			Author a = new Author(theBookAuthors.getAuthorId(),theBookAuthors.getAuthorName(),theBookAuthors.getExperience());
//			Book b = new Book(theBookAuthors.getBookId(), theBookAuthors.getBookName(), theBookAuthors.getBookPrice(), theBookAuthors.getJournal(), a);
//			theBooks.add(b);
//			theAuthors.add(a);
//			return b;
//		}
	
	//----------------testing exception upon adding a book--------------------

//	@PostMapping("/books")
//	public Book addBooks(@RequestBody BookAuthor theBookAuthors) {  
//		boolean bookExists = false;
//		boolean authorExists = false;
//		int temp = 0;
//		for(int i = 0 ; i < theBooks.size(); i++) {
//			if(theBookAuthors.getBookName().equals(theBooks.get(i).getBookName())) {
//			bookExists = true;	
//			if(theBookAuthors.getAuthorName().equals(theBooks.get(i).getBookAuthor())) {
//				authorExists = true;
//				break;
//			}
//		}
//		
//		}
//		if(bookExists && authorExists) {
//			// ---------------throw an exception here ----------------------
//			throw new BookAlreadyExistsException("Book already exists - "+theBookAuthors.getBookName()+" by "+theBookAuthors.getAuthorName());
//		}else {
//			for(int i = 0 ; i < theAuthors.size() ; i++) {
//				if(theBookAuthors.getAuthorName().equals(theAuthors.get(i).getAuthorName())) {
//					temp  = i;
//					break;
//				}
//			}
//			Author a = theAuthors.get(temp);
//			Book b = new Book(theBookAuthors.getBookId(), theBookAuthors.getBookName(), theBookAuthors.getBookPrice(), theBookAuthors.getJournal(), a);
//			theBooks.add(b);
//			return b;
//		}
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<BookErrorResponse> handleException(BookAlreadyExistsException exc){
//		//create a StudentErrorResponse
//		BookErrorResponse error = new BookErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		//return ResponseEntity
//		
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
	//----------------testing verison--------------------
	
	// add mapping for POST /author  -add new author
	@PostMapping("/authors")
	public Author addStudent(@RequestBody Author theAuthor) {  
		theAuthors.add(theAuthor);
		return theAuthor;
	}
	
}
