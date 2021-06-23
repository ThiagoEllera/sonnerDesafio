package com.desafio.sonner.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.desafio.sonner.modelo.NotaItem;

public class DetalhesDaNotaItemDto {

	private Integer id;
	private Integer numero;
	private BigDecimal quantidade;
	private Integer numeroNota;
	private List<ProdutoDto> produtos;
	
	public DetalhesDaNotaItemDto(NotaItem notaItem) {
		this.id = notaItem.getId();
		this.numero = notaItem.getNumero();
		this.quantidade = notaItem.getQuantidade();
		this.numeroNota = notaItem.getNota().getNumero();
		this.produtos = new ArrayList<>();
		this.produtos.addAll(notaItem.getProduto().getDescricao());
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public Integer getNumeroNota() {
		return numeroNota;
	}

	public List<ProdutoDto> getProdutos() {
		return produtos;
	}
	
}
