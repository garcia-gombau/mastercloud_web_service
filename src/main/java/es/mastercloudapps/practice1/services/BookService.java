package es.mastercloudapps.practice1.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import es.mastercloudapps.practice1.models.Book;
import es.mastercloudapps.practice1.models.MockBooks;

@Component
public class BookService {
	
	private AtomicLong nextId = new AtomicLong(); 
	
	private ConcurrentMap<Long, Book> books;
	
	public BookService(){
		this.books = MockBooks.getMockBooks();
		
	}
	
	public Collection<Book> getAllBooks() {
		return this.books.values();
	}
	
	public Book getBookById(Long id) {
		return this.books.get(id);
	}

}
