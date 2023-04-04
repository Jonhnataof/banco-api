package com.banco.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoapi.model.Transacao;
import com.banco.bancoapi.repository.TransacaoRepository;

@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public List<Transacao> findAll() {
		return (List<Transacao>) transacaoRepository.findAll();
	}

	public Optional<Transacao> findById(Integer id) {
		return transacaoRepository.findById(id);
	}

	public void save(Transacao transacao) {
		transacaoRepository.save(transacao);
		}
		
	public void delete(Integer id) {
		transacaoRepository.deleteById(id);
	}


}
