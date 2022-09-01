package com.tutorial.bookshelf.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.bookshelf.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

	List<Book> findAllByName(String name);
	List<Book> findAllByAuthor(String author);
	List<Book> findAllByGenre(String genre);
}
