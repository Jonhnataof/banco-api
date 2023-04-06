package com.banco.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoapi.exception.BancoBaseException;
import com.banco.bancoapi.exception.EmailJaUtilizadoException;
import com.banco.bancoapi.model.Cliente;
import com.banco.bancoapi.repository.ClienteRepository;
import com.banco.bancoapi.repository.ContaRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}

	public void save(Cliente cliente) {
		Cliente clienteEmail = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteEmail == null || clienteEmail.getId() == cliente.getId()) {
			clienteRepository.save(cliente);
		} else {
			throw new EmailJaUtilizadoException();
		}

	}

	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}

}
