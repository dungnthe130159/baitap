package com.example.JwtDemo.entity;

import com.example.JwtDemo.dto.Message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
	private Message message;
	private T result;
//	private int code;

	public Response() {
	}

	public Response(Message message, T result) {
		this.message = message;
		this.result = result;
//		this.code = code;
	}	

}
