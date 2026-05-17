package com.management.weight.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest wr) throws Exception {

		ExceptionResponse eres = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(eres, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MissingRequiredDataException.class)
	public final ResponseEntity<Object> handleMissingRequiredDataException(Exception ex, WebRequest wr) throws Exception {

		ExceptionResponse eres = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(eres, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnprocessableException.class)
	public final ResponseEntity<Object> handleUnprocessableException(Exception ex, WebRequest wr) throws Exception {

		ExceptionResponse eres = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(eres, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest wr) throws Exception {

		ExceptionResponse eres = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(eres, HttpStatus.NOT_FOUND);
	}
}
