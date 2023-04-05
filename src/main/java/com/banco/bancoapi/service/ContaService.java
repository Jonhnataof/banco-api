package com.banco.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoapi.model.Conta;
import com.banco.bancoapi.repository.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> findAll() {
		return (List<Conta>) contaRepository.findAll();
	}

	public Optional<Conta> findById(Integer id) {
		return contaRepository.findById(id);
	}

	public void save(Conta conta) {
		if (conta.getId()== null) {
			conta.setSaldo(0.0);
		}
		
		contaRepository.save(conta);
	}

	public void delete(Integer id) {
		contaRepository.deleteById(id);
	}

}
