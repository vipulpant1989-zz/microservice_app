package com.bbt.dao;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bbt.entity.Artist;

@Transactional
public interface IArtistRepository extends JpaRepository<Artist, Long> {

	@Cacheable(value = "artist")
	public Artist findByName(String name);

}
