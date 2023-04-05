package com.banco.bancoapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema="banco")
public class Transacao {
	@Id
	@SequenceGenerator(name = "pk_transacoes", sequenceName ="transacoes_id_seq" , allocationSize = 1, schema="banco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_transacoes")
	private Integer id;
	
	private String tipo;
	
	private String descricao;
	
	private Double valor;
	
	private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn(name="id_conta")
	private Conta conta;

}
