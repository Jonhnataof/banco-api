package com.banco.bancoapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaDTO {
	
	private String contaOrigem;
	
	private String contaDestino;
	
	private Double valor;
}
