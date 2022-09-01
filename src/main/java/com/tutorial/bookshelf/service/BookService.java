package com.tutorial.bookshelf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.bookshelf.model.Book;
import com.tutorial.bookshelf.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional<Book>findBookById(Long id){
		return bookRepository.findById(id);
	}
	
	public List<Book> findAllByName(String name){
		return bookRepository.findAllByName(name);
	}
	
	public List<Book> findAllByAuthor(String author){
		return bookRepository.findAllByAuthor(author);
	}
	
	public List<Book> findAllByGenre(String genre){
		return bookRepository.findAllByGenre(genre);
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public ResponseEntity<String> deleteBookById(Long id) {
		bookRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
