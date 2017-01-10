package com.bbt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "bbt_artist")
@JsonInclude(Include.NON_NULL)
public class Artist extends GenericArtistEntity {

	public Artist() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ART_SEQ")
	@SequenceGenerator(name = "ART_SEQ", sequenceName = "ART_SEQ", initialValue = 1, allocationSize = 100)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "origin")
	private String origin;

	@JoinColumn(name = "band_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Band band;

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

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

}
