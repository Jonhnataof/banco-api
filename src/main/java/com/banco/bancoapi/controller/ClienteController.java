package com.banco.bancoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancoapi.exception.BancoBaseException;
import com.banco.bancoapi.model.Cliente;
import com.banco.bancoapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping()
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> result = clienteService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Cliente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Cliente>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> findById(@PathVariable Integer id) {
		Optional<Cliente> result = clienteService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Cliente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Cliente>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Cliente cliente) {
		try {
			clienteService.save(cliente);

			return ResponseEntity.ok("Cliente criado com sucesso " + cliente.getId());
		} catch (BancoBaseException exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		} catch (Exception exception) {
			return ResponseEntity.internalServerError().body(exception.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		try {
			Cliente clienteAtualizado = clienteService.findById(id).get();
			clienteAtualizado.setNome(cliente.getNome());
			clienteAtualizado.setEmail(cliente.getEmail());
			clienteAtualizado.setEndereco(cliente.getEndereco());
			clienteAtualizado.setTelefone(cliente.getTelefone());
			clienteService.save(clienteAtualizado);

			return ResponseEntity.ok("Cliente atualizado com sucesso!");
		} catch (BancoBaseException exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		} catch (Exception exception) {
			return ResponseEntity.internalServerError().body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		clienteService.delete(id);

		return ResponseEntity.ok("Deletado");
	}

}
