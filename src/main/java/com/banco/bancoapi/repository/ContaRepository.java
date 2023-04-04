package com.banco.bancoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.bancoapi.model.Conta;


public interface ContaRepository extends CrudRepository<Conta, Integer>{

}
