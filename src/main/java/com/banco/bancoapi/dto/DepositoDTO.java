package com.banco.bancoapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositoDTO {
	
	private String numeroConta;
	
	private String descricao;
	
	private Double valor;

}
