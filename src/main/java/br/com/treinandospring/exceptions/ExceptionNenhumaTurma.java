package br.com.treinandospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ExceptionNenhumaTurma extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionNenhumaTurma(String message) {
		super(message);
	}
	
	

}
