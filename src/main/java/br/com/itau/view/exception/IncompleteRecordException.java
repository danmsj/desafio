package br.com.itau.view.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Registro ainda está sendo inserido")
public class IncompleteRecordException extends RuntimeException {

	public IncompleteRecordException() {
		super();
	}
}
