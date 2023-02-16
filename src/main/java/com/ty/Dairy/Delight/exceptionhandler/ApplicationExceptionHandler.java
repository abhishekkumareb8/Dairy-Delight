package com.ty.Dairy.Delight.exceptionhandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.Dairy.Delight.exception.NoSuchIdFoundException;
import com.ty.Dairy.Delight.exception.UnableToUpdateException;
import com.ty.Dairy.Delight.util.ResponseStructure;


@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();	
		for(ObjectError  error:errors) {
			String message =error.getDefaultMessage();
			String field =((FieldError)error).getField();
			map.put(field, message);
			
		}
		ResponseStructure<Map<String,String>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(HttpStatus.BAD_REQUEST.name());
		responseStructure.setData(map);
		
		return  new ResponseEntity<Object>(responseStructure,HttpStatus.BAD_REQUEST) ;
	
		
	}
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<?>> noSuchIdFoundException(NoSuchIdFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No such id found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseEntity<ResponseStructure<?>> unableToUpdateException(UnableToUpdateException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unable to update ");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
}
