package com.desafio.sonner.controller.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.repository.ClienteRepository;
import com.desafio.sonner.repository.NotaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AtulizacaoNotaForm {

	private Integer id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
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
