package com.desafio.sonner.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.sonner.modelo.Produto;
import com.desafio.sonner.repository.ProdutoRepository;

public class ProdutoForm {

	@NotNull @NotEmpty
	private String codigo;
	@NotNull @NotEmpty
	private String descricao;
	@NotNull 
	private BigDecimal valor;

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Produto converter() {
		return new Produto(codigo, descricao, valor);
	}

	public Produto atualizar(Integer id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getById(id);
		
		produto.setCodigo(this.codigo);
		produto.setDescricao(this.descricao);
		produto.setValor(this.valor);
		
		return produto;
	}
	
	
	
	
}
