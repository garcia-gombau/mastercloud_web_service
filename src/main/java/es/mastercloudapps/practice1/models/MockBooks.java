package es.mastercloudapps.practice1.models;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum MockBooks {
	BOOK0(0L, "The Stranger", "The protagonist, Mr. Meursault, will never speak out against his execution or show any feeling of injustice, regret or pity. Passivity and skepticism towards everything and everyone recover the behavior of the protagonist: an apathetic sense of existence and even death itself.","Albert Camus","Editions Gallimard","1942"),
	BOOK1(1L, "1984", "A man tries to keep hope in a totalitarian and repressive society. After falling in love with a young girl, they try to keep their love alive but hidden from the all-knowing Big Brother. This dark and virtual dictator seems to know what each one thinks in the corners of the mind.","George Orwell","Secker & Warburg","1949"),
	BOOK2(2L, "Enchiridion", "A practical philosophical guide instructing readers on how to live well from a primarily social perspective. In such a setting, The Enchiridion encourages one to enjoy the habits of moderation and modesty.","Epictetus","Secker & Warburg","125");
	
	public Long id;
	public String title;
	public String synopsis;
	public String author;
	public String editorial;
	public String publishYear;
	
	private MockBooks(Long id, String title, String synopsis, String author, String editorial, String publishYear) {
		this.id= id;
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.editorial = editorial;
		this.publishYear = publishYear;
	}
	
	public static ConcurrentMap<Long, Book> getMockBooks(){
		ConcurrentMap<Long,Book> booklist = new ConcurrentHashMap<>();
		for(MockBooks book:MockBooks.values()) {
			booklist.put(book.id, new Book(book.id, book.title, book.synopsis, book.author, book.editorial, book.publishYear, MockReviews.getMockReviews()));
		}
		return booklist;
	}
}
