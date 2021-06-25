package com.desafio.sonner.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafio.sonner.modelo.Nota;

public class NotaDto {
	
	private Integer id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCompra;
	private Integer numero;
	
	public NotaDto(Nota nota) {
		this.id = nota.getId();
		this.dataCompra = nota.getDataCompra();
		this.numero = nota.getNumero();
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
