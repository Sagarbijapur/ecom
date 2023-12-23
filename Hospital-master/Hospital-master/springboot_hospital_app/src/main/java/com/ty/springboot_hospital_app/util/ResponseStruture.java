package com.ty.springboot_hospital_app.util;

import lombok.Data;

@Data
public class ResponseStruture <T> {

	private String message;
	private int status;
	private T data;
	
}
