package com.vsms.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationExceptionHanlder(MethodArgumentNotValidException ex) {

		// Inner class
		class fieldErrorDto {

			private String fieldName;
			private String errorMessage;

			public fieldErrorDto(String fieldName, String errorMessage) {
				this.fieldName = fieldName;
				this.errorMessage = errorMessage;
			}

			public String getFieldName() {
				return fieldName;
			}

			public void setFieldName(String fieldName) {
				this.fieldName = fieldName;
			}

			public String getErrorMessage() {
				return errorMessage;
			}

			public void setErrorMessage(String errorMessage) {
				this.errorMessage = errorMessage;
			}

		}
		List<FieldError> errors = ex.getFieldErrors();
		Stream<Object> result = errors.stream().map(error -> new fieldErrorDto(error.getField(),error.getDefaultMessage()));
		return Response.error(result);
	}

}
