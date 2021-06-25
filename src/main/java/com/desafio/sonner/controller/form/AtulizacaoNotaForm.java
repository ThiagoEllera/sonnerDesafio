package com.desafio.sonner.controller.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.repository.ClienteRepository;
import com.desafio.sonner.repository.NotaRepository;

public class AtulizacaoNotaForm {

	private Integer id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCompra;
	private Integer numero;
	private String nomeCliente;

	public Integer getId() {
		return id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public Nota atualizar(Integer id, NotaRepository notaRepository, ClienteRepository clienteRepository){
		Nota nota = notaRepository.getById(id);
		
		nota.setNumero(this.numero);
		nota.setDataCompra(this.dataCompra);
		nota.setCliente(clienteRepository.getByNome(nomeCliente));
		
		return nota;	
		
	}
	
	
}
