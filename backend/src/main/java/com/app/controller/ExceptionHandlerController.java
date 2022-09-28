package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController  {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException ex) {
		// local class
		class FieldErrorDto {
			private String fieldName;
			private String errorMessage;

			public FieldErrorDto(String fieldName, String errorMessage) {
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

		Map<String, Object> map = new HashMap<String, Object>();

		List<FieldError> errors = ex.getFieldErrors();
		Stream<FieldErrorDto> result = errors.stream()
				.map(err -> new FieldErrorDto(err.getField(), err.getDefaultMessage()));

		map.put("status", "error");
		map.put("error", result);
		return ResponseEntity.ok(map);
	}
	
}
