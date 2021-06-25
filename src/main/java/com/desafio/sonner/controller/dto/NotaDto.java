package com.desafio.sonner.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.desafio.sonner.modelo.Nota;
import com.fasterxml.jackson.annotation.JsonFormat;

public class NotaDto {
	
	private Integer id;
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataCompra;
	@NotNull
	private Integer numero;
	@NotNull
	private String nomeCliente;
	
	
	public NotaDto(Nota nota) {
		this.id = nota.getId();
		this.dataCompra = nota.getDataCompra();
		this.numero = nota.getNumero();
		this.nomeCliente = nota.getCliente().getNome();
	}

	public Integer getId() {
		return id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public Integer getNumero() {
		return numero;
	}

	public static List<NotaDto> converter(List<Nota> nota) {
		return nota.stream().map(NotaDto::new).collect(Collectors.toList());
		
	}
	
	

}
