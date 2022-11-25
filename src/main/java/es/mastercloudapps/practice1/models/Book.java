package es.mastercloudapps.practice1.models;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class Book {
	private Long id;
	private String title;
	private String synopsis;
	private String author;
	private String publisher;
	private String publishYear;
	private ConcurrentMap<Long, Review> reviews;
	
	public Book(Long id, String title, String synopsis, String author, String publisher, String publishYear, ConcurrentMap<Long, Review> reviews) {
		this.id = id; 
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	
	public ConcurrentMap<Long, Review> getReviews() {
		return reviews;
	}

	public Collection<Review> getReviewsValues() {
		return reviews.values();
	}
	
	public void setReviews(ConcurrentMap<Long, Review> reviews) {
		this.reviews = reviews;
	}

}
