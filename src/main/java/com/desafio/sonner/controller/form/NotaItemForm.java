package com.desafio.sonner.controller.form;

import java.math.BigDecimal;

import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.modelo.NotaItem;
import com.desafio.sonner.modelo.Produto;
import com.desafio.sonner.repository.NotaRepository;
import com.desafio.sonner.repository.ProdutoRepository;

public class NotaItemForm {

	private Integer numero;
	private BigDecimal quantidade;	
	private Integer numeroNota;
	private String nomeProduto;
	
	
	
	
	public Integer getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public NotaItem converter(NotaRepository notaRepository, ProdutoRepository produtoRepository) {
		Nota nota = notaRepository.findByNumero(numeroNota);
		Produto produto = produtoRepository.findByDescricao(nomeProduto);
		return new NotaItem(numero, quantidade, nota, produto);
	}
	
	
}
