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

import com.banco.bancoapi.model.Conta;
import com.banco.bancoapi.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	@Autowired
	private ContaService contaService;
	
	@GetMapping()
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> result = contaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Conta>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Conta>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Conta>> findById(@PathVariable Integer id) {
		Optional<Conta> result = contaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Conta>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Conta>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Conta> save(@RequestBody Conta conta) {
		
		
		contaService.save(conta);

		return ResponseEntity.ok(conta);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Conta> update(@PathVariable Integer id, @RequestBody Conta conta) {
		Conta contaAtualizada = contaService.findById(id).get();
		contaAtualizada.setNumeroConta(conta.getNumeroConta());
		contaAtualizada.setCliente(conta.getCliente());
		
		return ResponseEntity.ok(contaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		contaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
