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

import com.banco.bancoapi.dto.DepositoDTO;
import com.banco.bancoapi.dto.TransferenciaDTO;
import com.banco.bancoapi.model.Transacao;
import com.banco.bancoapi.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoConntroller {
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping("/deposito")
	public ResponseEntity<String> deposito (@RequestBody DepositoDTO deposito ) {
		
		transacaoService.depositar(deposito);
		
		return ResponseEntity.ok("Deposito realizado com sucesso!");
		
		
	}


	@PostMapping("/transferencia")
	public ResponseEntity<String> transferencia (@RequestBody TransferenciaDTO transferencia) {
		
		
		transacaoService.transferir(transferencia);

		return ResponseEntity.ok("Transferencia realizada com sucesso!");
	}

	

}
