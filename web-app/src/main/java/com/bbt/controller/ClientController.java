package com.bbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.client.ArtistClient;
import com.bbt.entity.Artist;
import com.bbt.types.ResponseTO;

@RequestMapping("/artists")
@RestController
public class ClientController extends BaseController<Artist> {

	@Autowired
	ArtistClient artistClient;

	@Override
	public List<Artist> getAll() {
		return artistClient.getAll();
	}

	@Override
	public ResponseEntity<ResponseTO<Boolean>> deleteOne(@PathVariable Long id) {
		return artistClient.deleteOne(id);
	}

	@Override
	public ResponseTO<Artist> getOne(@PathVariable Long id) {
		return artistClient.getOne(id).getBody();
	}

	@Override
	public ResponseEntity<ResponseTO<Artist>> save(Artist artist) {
		return artistClient.save(artist);
	}

}
