package com.desafio.sonner.controller.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.desafio.sonner.modelo.Nota;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DetalhesNotaDto {

	private Integer id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataCompra;
	private Integer numero;
	private List<NotaItemDto> notaItems;
	
	public DetalhesNotaDto(Nota nota) {
		this.id = nota.getId();
		this.dataCompra = nota.getDataCompra();
		this.numero = nota.getNumero();
		this.notaItems = new ArrayList<>();
		this.notaItems.addAll(nota.getNotaItem().stream().map(NotaItemDto::new).collect(Collectors.toList()));
				
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

	public List<NotaItemDto> getNotaItems() {
		return notaItems;
	}


	
	
}
