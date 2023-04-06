package com.banco.bancoapi.exception;

public  class EmailJaUtilizadoException extends BancoBaseException {
	public EmailJaUtilizadoException () {
		super("Email ja está sendo utilizado!");
	}

}
