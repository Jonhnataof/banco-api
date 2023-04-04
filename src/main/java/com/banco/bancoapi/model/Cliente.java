package com.banco.bancoapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(schema="banco")
public class Cliente {
	@Id
	@SequenceGenerator(name = "pk_cliente", sequenceName ="clientes_id_seq" , allocationSize = 1, schema="banco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_cliente")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String endereco;
	
	private String telefone;

}
