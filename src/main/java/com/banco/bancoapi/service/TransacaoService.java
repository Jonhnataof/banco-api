package com.banco.bancoapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancoapi.dto.DepositoDTO;
import com.banco.bancoapi.dto.TransferenciaDTO;
import com.banco.bancoapi.exception.ContaNaoEncontradaException;
import com.banco.bancoapi.exception.SaldoInsuficienteException;
import com.banco.bancoapi.model.Conta;
import com.banco.bancoapi.model.Transacao;
import com.banco.bancoapi.repository.ContaRepository;
import com.banco.bancoapi.repository.TransacaoRepository;

@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	public List<Transacao> findAll() {
		return (List<Transacao>) transacaoRepository.findAll();
	}

	public Optional<Transacao> findById(Integer id) {
		return transacaoRepository.findById(id);
	}

	public void transferir(TransferenciaDTO transferencia) {

		Conta contaOrigem = contaRepository.findByNumeroConta(transferencia.getContaOrigem());
		if (contaOrigem == null ){
			throw new ContaNaoEncontradaException("Conta de origem não encontrada!");
		}
		

		if (contaOrigem.getSaldo() >= transferencia.getValor()) {

			Double novoSaldoOrigem = contaOrigem.getSaldo() - transferencia.getValor();
			contaOrigem.setSaldo(novoSaldoOrigem);


			Conta contaDestino = contaRepository.findByNumeroConta(transferencia.getContaDestino());
			if (contaDestino == null ) {
				throw new ContaNaoEncontradaException("Conta de Destino não encontrada!");
			}
			
			contaRepository.save(contaOrigem);

			
			Double novoSaldoDestino = contaDestino.getSaldo() + transferencia.getValor();
			contaDestino.setSaldo(novoSaldoDestino);

			contaRepository.save(contaDestino);

			Transacao transferenciaSai = new Transacao();
			transferenciaSai.setTipo("TRANSFERENCIA_SAI");
			transferenciaSai.setValor(transferencia.getValor());
			transferenciaSai.setDataHora(LocalDateTime.now());
			transferenciaSai.setConta(contaOrigem);

			transacaoRepository.save(transferenciaSai);

			Transacao transferenciaEnt = new Transacao();
			transferenciaEnt.setTipo("TRANSFERENCIA_ENT");
			transferenciaEnt.setValor(transferencia.getValor());
			transferenciaEnt.setDataHora(LocalDateTime.now());
			transferenciaEnt.setConta(contaDestino);

			transacaoRepository.save(transferenciaEnt);

		}else {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar operação!");
		}
		
	}

	public void depositar(DepositoDTO deposito) {

		Conta conta = contaRepository.findByNumeroConta(deposito.getNumeroConta());
		Double novoSaldo = conta.getSaldo() + deposito.getValor();
		conta.setSaldo(novoSaldo);
		contaRepository.save(conta);

		Transacao transacaoDeposito = new Transacao();
		transacaoDeposito.setConta(conta);
		transacaoDeposito.setDescricao(deposito.getDescricao());
		transacaoDeposito.setValor(deposito.getValor());
		transacaoDeposito.setTipo("DEPOSITO");
		transacaoDeposito.setDataHora(LocalDateTime.now());

		transacaoRepository.save(transacaoDeposito);
	}

	public void delete(Integer id) {
		transacaoRepository.deleteById(id);
	}

}
