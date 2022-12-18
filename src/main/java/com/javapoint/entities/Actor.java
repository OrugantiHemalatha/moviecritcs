package com.javapoint.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "actor")
@Table
public class Actor 
{
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_id_sequence")
	@Column(name = "actor_id", updatable = false)
	private int actor_id;
	
	private String actor_name;

	@JsonIgnore
	@ManyToMany(mappedBy = "actor", fetch = FetchType.EAGER)
	private Set<Movie> movie;

	public Actor() {
		super();
	}

	public Actor(int actor_id, String actor_name, Set<Movie> movie) 
	{
		super();
		this.actor_id = actor_id;
		this.actor_name = actor_name;
		this.movie = movie;
	}

	public int getActor_id() 
	{
		return actor_id;
	}

	public void setActor_id(int actor_id)
	{
		this.actor_id = actor_id;
	}

	public String getActor_name() 
	{
		return actor_name;
	}

	public void setActor_name(String actor_name) 
	{
		this.actor_name = actor_name;
	}

	public Set<Movie> getMovie() 
	{
		return movie;
	}

	public void setMovie(Set<Movie> movie) 
	{
		this.movie = movie;
	}

}
