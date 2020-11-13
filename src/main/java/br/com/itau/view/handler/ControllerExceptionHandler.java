package br.com.itau.view.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.itau.view.exception.ErrorResponse;
import br.com.itau.view.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleFieldValidationException(final ValidationException ex) {
		final ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), ex.getErrors());
		log.info("ValidationException: {}", error);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleFieldServiceException(final Exception ex) {
		log.error("Uncaught Exception: {}", ex);
		final ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getClass().getName(), "Ocorreu um erro inesperado, contate o administrador do sistema!");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}



}