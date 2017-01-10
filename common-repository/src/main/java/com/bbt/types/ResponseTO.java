package com.bbt.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ResponseTO<T> {

	@JsonCreator
	public ResponseTO(@JsonProperty("success") T success, ErrorTO error) {
		this.error = error;
		this.success = success;
	}

	private T success;

	private ErrorTO error;

	public T getSuccess() {
		return success;
	}

	public ErrorTO getError() {
		return error;
	}

	public void setError(ErrorTO error) {
		this.error = error;
	}
}
