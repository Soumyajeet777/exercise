package com.group.exercise.exception;

public class InvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidException(String s){
		 super(s);
	}
}
