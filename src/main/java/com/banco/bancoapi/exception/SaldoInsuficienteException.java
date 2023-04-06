package com.banco.bancoapi.exception;

public class SaldoInsuficienteException extends BancoBaseException {
 
	public SaldoInsuficienteException (String message) {
		super(message);
	}
}
