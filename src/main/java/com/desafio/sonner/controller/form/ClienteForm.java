package com.desafio.sonner.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.sonner.modelo.Cliente;
import com.desafio.sonner.repository.ClienteRepository;

public class ClienteForm {

	@NotNull @NotEmpty
	private String codigo;
	@NotNull @NotEmpty
	private String nome;
	

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public Cliente converter() {		
		return new Cliente(codigo, nome);
	}

	public Cliente atualizar(Integer id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getById(id);
		
		cliente.setCodigo(this.codigo);
		cliente.setNome(this.nome);
		return cliente;
	}
}
