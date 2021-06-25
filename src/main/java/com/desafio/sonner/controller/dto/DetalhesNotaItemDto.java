package com.desafio.sonner.controller.dto;

import java.math.BigDecimal;

import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.modelo.NotaItem;
import com.desafio.sonner.modelo.Produto;

public class DetalhesNotaItemDto {

	private Integer id;
	private Nota nota;
	private Integer numero;
	private Produto produto;
	private BigDecimal quantidade;
	
	public DetalhesNotaItemDto(NotaItem notaItem) {
		
		this.id = notaItem.getId();
		this.nota = notaItem.getNota();
		this.numero = notaItem.getNumero();
		this.produto = notaItem.getProduto();
		this.quantidade = notaItem.getQuantidade();			
	}

	public Integer getId() {
		return id;
	}

	public Nota getNota() {
		return nota;
	}

	public Integer getNumero() {
		return numero;
	}

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	
}
