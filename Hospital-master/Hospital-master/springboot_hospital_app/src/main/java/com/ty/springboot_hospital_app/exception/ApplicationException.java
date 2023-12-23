package com.ty.springboot_hospital_app.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_app.util.ResponseStruture;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStruture<String>> idNotFound(IdNotFoundException ex) {
		ResponseStruture<String> responseStruture = new ResponseStruture<String>();
		responseStruture.setMessage(ex.getMessage());
		responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
		responseStruture.setData("no id found");

		return new ResponseEntity<ResponseStruture<String>>(responseStruture, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElement(NoSuchElementException ex) {
		ResponseStruture<String> responseStruture = new ResponseStruture<String>();
		responseStruture.setMessage(ex.getMessage());
		responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
		responseStruture.setData("no element found for the given id");
		return new ResponseEntity<ResponseStruture<String>>(responseStruture, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();

		for (ObjectError er : error) {

			String feildName = ((FieldError) er).getField();
			String message = ((FieldError) er).getDefaultMessage();

			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStruture<Object>> handleConstraintViolationException(
			ConstraintViolationException exception) {
		Collection<ConstraintViolation<?>> set=exception.getConstraintViolations();
		List<String> list=new ArrayList<>();
		for(ConstraintViolation<?> constraintViolation :set){
			String name=constraintViolation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<ResponseStruture<Object>>(HttpStatus.BAD_REQUEST);
		
	}
	
}
