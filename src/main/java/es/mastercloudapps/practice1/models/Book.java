package es.mastercloudapps.practice1.models;

import java.util.List;

public class Book {
	
	private Long id;
	private String title;
	private String synopsis;
	private String author;
	private String editorial;
	private String publishYear;
	private List<Review> reviews;
	
	public Book(Long id, String title, String synopsis, String author, String editorial, String publishYear, List<Review> reviews) {
		this.id = id; 
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.editorial = editorial;
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
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
