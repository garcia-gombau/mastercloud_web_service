package es.mastercloudapps.practice1.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import es.mastercloudapps.practice1.models.Review;
import org.springframework.stereotype.Component;

import es.mastercloudapps.practice1.models.Book;
import es.mastercloudapps.practice1.models.MockBooks;

@Component
public class BookService {
	
	private AtomicLong nextBookId = new AtomicLong();
	private AtomicLong nextReviewId = new AtomicLong();

	private ConcurrentMap<Long, Book> books;
	
	public BookService(){
		this.books = MockBooks.getMockBooks(nextBookId, nextReviewId);
	}
	
	public Collection<Book> getAllBooks() {
		return this.books.values();
	}
	
	public Book getBookById(Long id) {
		return this.books.get(id);
	}

	public Book deleteReview(Long bookId, Long reviewId) {
		Book book = this.books.get(bookId);
		ConcurrentMap<Long, Review> reviews = book.getReviews();
		reviews.remove(reviewId);
		book.setReviews(reviews);
		this.books.replace(bookId, book);
		return book;
	}

	public Book addReview(Long bookId, String username, String comment, String rate) {
		Book book = this.books.get(bookId);
		Long id = nextReviewId.getAndIncrement();
		ConcurrentMap<Long, Review> reviews = book.getReviews();
		reviews.put(id, new Review(id, username, comment, Integer.parseInt(rate)));
		book.setReviews(reviews);
		this.books.replace(bookId, book);
		return book;
	}

	public Book addNewBook(String title, String synopsis, String author, String publisher, String publishyear) {
		Long id = nextBookId.getAndIncrement();
		this.books.put(id,new Book(id, title, synopsis, author, publisher, publishyear, new ConcurrentHashMap<>()));
		return this.books.get(id);
	}

}
