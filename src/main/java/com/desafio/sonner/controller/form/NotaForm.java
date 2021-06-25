package com.desafio.sonner.controller.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafio.sonner.modelo.Cliente;
import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.repository.ClienteRepository;

public class NotaForm {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCompra;
	private Integer numero;
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
