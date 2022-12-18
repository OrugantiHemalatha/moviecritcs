package com.javapoint.entities;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "movie")
@Table
public class Movie {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movie_id;


	private String movie_name;

	private String movie_categories;


	private String movie_language;


	private String movie_genres;


	private Date release_date;


	private LocalTime movie_duration;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String movie_poster;
	
    @JsonManagedReference
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Review> review;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movie_actor", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "actor_id") })
	private Set<Actor> actor;

	public Movie() {
		super();
	}

	public Movie(int movie_id, String movie_name, String movie_categories, String movie_language, String movie_genres,
			Date release_date, LocalTime movie_duration, String movie_poster, List<Review> review, Set<Actor> actor) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.movie_categories = movie_categories;
		this.movie_language = movie_language;
		this.movie_genres = movie_genres;
		this.release_date = release_date;
		this.movie_duration = movie_duration;
		this.movie_poster = movie_poster;
		this.review = review;
		this.actor = actor;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_categories() {
		return movie_categories;
	}

	public void setMovie_categories(String movie_categories) {
		this.movie_categories = movie_categories;
	}

	public String getMovie_language() {
		return movie_language;
	}

	public void setMovie_language(String movie_language) {
		this.movie_language = movie_language;
	}

	public String getMovie_genres() {
		return movie_genres;
	}

	public void setMovie_genres(String movie_genres) {
		this.movie_genres = movie_genres;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public LocalTime getMovie_duration() {
		return movie_duration;
	}

	public void setMovie_duration(LocalTime movie_duration) {
		this.movie_duration = movie_duration;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Set<Actor> getActor() {
		return actor;
	}

	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}
	public Movie(int i, String string, String string2, String string3, String string4, int j, String string5,
			String string6) {
	}

}
