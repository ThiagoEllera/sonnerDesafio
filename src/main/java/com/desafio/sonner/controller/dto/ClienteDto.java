package com.desafio.sonner.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.desafio.sonner.modelo.Cliente;

public class ClienteDto {

	private Integer id;
	private String codigo;
	private String nome;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.codigo = cliente.getCodigo();
		this.nome = cliente.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public static List<ClienteDto> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
}
