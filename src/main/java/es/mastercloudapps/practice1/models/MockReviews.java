package es.mastercloudapps.practice1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum MockReviews {
	REVIEW0("random_", "Awful.", 0),
	REVIEW1("random_", "Boring.", 1),
	REVIEW2("random_", "Forgetable.", 2),
	REVIEW3("random_", "Interesting.", 3),
	REVIEW4("random_", "Amazing.", 4),
	REVIEW5("random_", "GOAT.", 5);
	
	public String username;
	public String comment;
	public int rate;
	
	private MockReviews(String username, String comment, int rate) {
		this.username = username;
		this.comment = comment;
		this.rate = rate;
	}
	
	public static List<Review> getMockReviews(){
		List<Review> reviews = new ArrayList<>();
		for (int i = 0; i < 2;i++) {
			MockReviews mock = MockReviews.getMockReview(new Random().nextInt(0, 5));
			reviews.add(new Review(i, mock.username+(new Random().nextInt(1960, 2017)), mock.comment, mock.rate));
		}
		return reviews;
	}
	
	private static MockReviews getMockReview(int ordinal) {
		MockReviews review = MockReviews.REVIEW0;
		for(MockReviews value: MockReviews.values()) {
			if (value.ordinal() == ordinal) {
				review = value;
			}
		}
		return review;
	}
}
