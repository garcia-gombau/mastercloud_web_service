package es.mastercloudapps.practice1.models;

public class Review {
	
	private Long id;
	private String username;
	private String comment;
	private int rate;
	
	public Review(Long id, String username, String comment, int rate) {
		this.id = id;
		this.username = username;
		this.comment = comment;
		this.rate = rate;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	

}
