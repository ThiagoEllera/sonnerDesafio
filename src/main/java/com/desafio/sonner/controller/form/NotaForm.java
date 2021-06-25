package com.desafio.sonner.controller.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.sonner.modelo.Cliente;
import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.repository.ClienteRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

public class NotaForm {
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataCompra;
	@NotNull
	private Integer numero;
	@NotNull @NotEmpty
	private String nomeCliente;

	public Date getDataCompra() {
		return dataCompra;
	}

	public Integer getNumero() {
		return numero;
	}
	

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Nota converter(ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getByNome(nomeCliente);
		return new Nota(numero, dataCompra, cliente);
	}
	
	
	

}
