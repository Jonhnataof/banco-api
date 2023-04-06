package com.banco.bancoapi.exception;

public abstract class BancoBaseException extends RuntimeException {

	public BancoBaseException(String message) {
		super(message);
	}
}
