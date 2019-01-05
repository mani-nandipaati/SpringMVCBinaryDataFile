package com.cts.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.BookDao;
import com.cts.iiht.model.Book;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	public void addBook(Book book ) {
		bookDao.addBook(book);
	}
	
	public void deleteBook(long id) {
		bookDao.deleteBook(id);
	}

	public Book searchBook(long id) {
		return bookDao.searchBook(id);
	}

	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
}
