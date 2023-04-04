package com.banco.bancoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.bancoapi.model.Transacao;


public interface TransacaoRepository extends CrudRepository<Transacao, Integer>{

}
