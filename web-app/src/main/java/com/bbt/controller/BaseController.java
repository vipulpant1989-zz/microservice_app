package com.bbt.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.entity.Artist;
import com.bbt.types.ResponseTO;

@RestController
public abstract class BaseController<T> {

	@RequestMapping(method = RequestMethod.GET)
	public abstract List<T> getAll();

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public abstract ResponseEntity<ResponseTO<Boolean>> deleteOne(
			@PathVariable("id") Long id);

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public abstract ResponseTO<Artist> getOne(@PathVariable("id") Long id);

	@RequestMapping(value = "/artists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public abstract ResponseEntity<ResponseTO<T>> save(@RequestBody T obj);

}
