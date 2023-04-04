package com.banco.bancoapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema="banco")
public class Conta {
	@Id
	@SequenceGenerator(name = "pk_contas", sequenceName ="contas_id_seq" , allocationSize = 1, schema="banco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_contas")
	private Integer id;
	
	@Column(unique=true)
	private String numeroConta;
	
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

}
