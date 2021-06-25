package com.desafio.sonner.controller.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.modelo.NotaItem;

public class DetalhesNotaDto {

	private Integer id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCompra;
	private Integer numero;
	private List<NotaItem> notaItem = new ArrayList<>();
	
	public DetalhesNotaDto(Nota nota) {
		this.id = nota.getId();
		this.dataCompra = nota.getDataCompra();
		this.numero = nota.getNumero();
		this.notaItem.addAll(nota.getNotaItem().stream().map(DetalhesNotaItemDto::new).collect(Collectors.toList()));
				
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

	public List<NotaItem> getNotaItem() {
		return notaItem;
	}
	
	
}
