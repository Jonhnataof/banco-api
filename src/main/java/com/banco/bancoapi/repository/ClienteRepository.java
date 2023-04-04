package com.banco.bancoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.bancoapi.model.Cliente;


public interface ClienteRepository extends CrudRepository <Cliente, Integer> {
	Cliente findByEmail(String email);
}
