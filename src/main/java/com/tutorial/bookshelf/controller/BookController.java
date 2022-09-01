package com.tutorial.bookshelf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.bookshelf.model.Book;
import com.tutorial.bookshelf.service.BookService;

@RestController
public class BookController {

	private BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * Find all books
	 */
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return bookService.findAllBooks();
	}
	
	/**
	 * Find book by given Id
	 */
	@GetMapping("/books/{id}")
	public Optional<Book> findBookByID(@PathVariable Long id){
		return bookService.findBookById(id);
	}
	
	/**
	 * Find all books by given book name
	 */
	@GetMapping(value = "/books", params = {"name"})
	public List<Book> findBooksByName(@RequestParam("name") String name){
		return bookService.findAllByName(name);
	}
	
	/**
	 * Find all books by given author
	 */
	@GetMapping(value = "/books", params = {"author"})
	public List<Book> findBooksByAuthor(@RequestParam("author") String author){
		return bookService.findAllByAuthor(author);
	}
	
	/**
	 * Find all books by given genre
	 */
	@GetMapping(value = "/books", params = {"genre"})
	public List<Book> findBooksByGenre(@RequestParam("genre") String genre){
		return bookService.findAllByGenre(genre);
	}
	
	/**
	 * Add a new book entry. Pass the book entity in request body.
	 */
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	/**
	 * Delete the specified book by Id
	 */
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
		return bookService.deleteBookById(id);
	}
}
