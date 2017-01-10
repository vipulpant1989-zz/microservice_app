package com.bbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.dao.IArtistRepository;
import com.bbt.entity.Artist;
import com.bbt.types.ResponseTO;

@RestController
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
	IArtistRepository artistRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Artist> getAll() {
		return artistRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Artist>> save(@RequestBody Artist artist) {
		ResponseTO<Artist> response = new ResponseTO<>(
				artistRepository.save(artist), null);
		ResponseEntity<ResponseTO<Artist>> reponseEntity = new ResponseEntity<>(
				response, HttpStatus.OK);
		return reponseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Artist>> getOne(@PathVariable long id) {
		ResponseTO<Artist> response = new ResponseTO<Artist>(
				artistRepository.getOne(id), null);
		ResponseEntity<ResponseTO<Artist>> reponseEntity = new ResponseEntity<>(
				response, HttpStatus.OK);
		return reponseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Boolean>> deleteOne(@PathVariable long id) {
		artistRepository.delete(id);
		ResponseTO<Boolean> response = new ResponseTO<>(Boolean.TRUE, null);
		ResponseEntity<ResponseTO<Boolean>> reponseEntity = new ResponseEntity<>(
				response, HttpStatus.OK);
		return reponseEntity;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Artist>> getByName(
			@RequestParam(value = "name") String name) {
		Artist artist = artistRepository.findByName(name);
		ResponseTO<Artist> response = new ResponseTO<Artist>(artist, null);
		return new ResponseEntity<ResponseTO<Artist>>(response, HttpStatus.OK);
	}

}
