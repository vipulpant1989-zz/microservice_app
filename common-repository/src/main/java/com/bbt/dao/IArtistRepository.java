package com.bbt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbt.entity.Artist;

public interface IArtistRepository extends JpaRepository<Artist, Long> {

	public Artist findByName(String name);

}
