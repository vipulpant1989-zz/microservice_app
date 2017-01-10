package com.bbt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "bbt_band")
@JsonInclude(Include.NON_NULL)
public class Band extends GenericArtistEntity {

	public Band() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BAND_SEQ")
	@SequenceGenerator(name = "BAND_SEQ", sequenceName = "BAND_SEQ", initialValue = 1, allocationSize = 100)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "origin")
	private String origin;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Artist> artists;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

}
