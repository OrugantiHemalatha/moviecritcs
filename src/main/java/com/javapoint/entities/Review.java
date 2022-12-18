package com.javapoint.entities;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity(name = "review")
@Table
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int review_id;
    private String movie_reviews;
    private double movie_ratings;
    private String content;
    
    @JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Movie movie;
    @OneToOne(fetch = FetchType.EAGER)
	private User user;
    public Review() 
    {
		super();
	}
	public Review(int review_id, String movie_reviews, double movie_ratings, String content) {
	}

	public Review(int review_id, String movie_reviews, double movie_ratings, String content, Movie movie, User user) {
		super();
		this.review_id = review_id;
		this.movie_reviews = movie_reviews;
		this.movie_ratings = movie_ratings;
		this.content = content;
		this.movie = movie;
		this.user = user;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getMovie_reviews() {
		return movie_reviews;
	}

	public void setMovie_reviews(String movie_reviews) {
		this.movie_reviews = movie_reviews;
	}

	public double getMovie_ratings() {
		return movie_ratings;
	}

	public void setMovie_ratings(double movie_ratings) {
		this.movie_ratings = movie_ratings;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}