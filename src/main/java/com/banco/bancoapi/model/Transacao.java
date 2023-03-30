package com.banco.bancoapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

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
	
	private Double decimal;
	
	private LocalDateTime dataHora;
	
	@OneToMany
	@JoinColumn(name="id_contaOrigem")
	private Integer contaOrigemId;
	
	@OneToMany
	@JoinColumn(name="id_contaDestino")
	private Integer contaDestinoId;

}