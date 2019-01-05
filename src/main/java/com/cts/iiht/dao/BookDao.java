package com.cts.iiht.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cts.iiht.model.Book;
import com.cts.iiht.util.SerializationUtils;

@Component
public class BookDao {


	public void addBook(Book book ) {
		Object obj = SerializationUtils.deSerialize("bookFile.ser");
		List<Book> books;
		if(obj != null) {
			books = (List<Book>) obj;
		}
		else {
			books = new ArrayList<>();
		}
		books.add(book);
		SerializationUtils.serialize(books, "bookFile.ser");
		System.out.println("Book added succesfully");
	}

	public void deleteBook(long id) {
		Object obj = SerializationUtils.deSerialize("bookFile.ser");
		List<Book> books;
		List<Book> updatedBooks = new ArrayList<>();
		boolean found = false;
		if(obj != null) {
			books = (List<Book>) obj;
			for(Book book : books) {
				if(book.getBookId() == id) {
					found = true;
					System.out.format("\n%10s %15s %15s %15s %15s", "Id", "Price", "Title", "Volume", "Publish Date");
					System.out.format("\n%10d %15.2f %15s %15d %15s \n", book.getBookId(), book.getPrice(), book.getTitle(),
							book.getVolume(), book.getPublishDate());
					System.out.println("Book Deleted Successfully");
				}else {
					updatedBooks.add(book);
				}
			}
		}
		if(found) {
			SerializationUtils.serialize(updatedBooks, "bookFile.ser");
		}
		else {
			System.out.println("Unable to find Book with id "+ id);	
		}
	}

	public Book searchBook(long id) {
		Object obj = SerializationUtils.deSerialize("bookFile.ser");
		List<Book> books;
		boolean found = false;
		if(obj != null) {
			books = (List<Book>) obj;
			for(Book book : books) {
				if(book.getBookId() == id) {
					found = true;
					System.out.format("\n%10s %15s %15s %15s %15s", "Id", "Price", "Title", "Volume", "Publish Date");
					System.out.format("\n%10d %15.2f %15s %15d %15s \n", book.getBookId(), book.getPrice(), book.getTitle(),
							book.getVolume(), book.getPublishDate());
					return book;
				}
			}
		}
		if (!found) {
			System.out.println("Unable to find Book with id "+ id);
		}
		return null;
	}
	
	public List<Book> getAllBooks() {
		Object obj = SerializationUtils.deSerialize("bookFile.ser");
		List<Book> books = null;
		boolean found = false;
		if(obj != null) {
			books = (List<Book>) obj;
		}
		return books;
	}
}
