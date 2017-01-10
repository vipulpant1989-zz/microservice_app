package com.bbt.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbt.entity.Artist;
import com.bbt.types.ResponseTO;

@FeignClient("artist-service")
public interface ArtistClient {

	@RequestMapping(value = "/artists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Artist> getAll();

	@RequestMapping(value = "/artists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Artist>> save(@RequestBody Artist artist);

	@RequestMapping(value = "/artists/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Artist>> getOne(@PathVariable("id") long id);

	@RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<Boolean>> deleteOne(
			@PathVariable("id") long id);

}
