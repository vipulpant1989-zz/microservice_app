package com.bbt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericArtistEntity extends GenericEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericArtistEntity() {
	}

	@Column(name = "facebook")
	private String facebook;

	@Column(name = "twitter")
	private String twitter;

	@Column(name = "soundcloud")
	private String soundcloud;

	@Column(name = "genres")
	@ElementCollection
	private List<String> genres = new ArrayList<>();

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSoundcloud() {
		return soundcloud;
	}

	public void setSoundcloud(String soundcloud) {
		this.soundcloud = soundcloud;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

}
