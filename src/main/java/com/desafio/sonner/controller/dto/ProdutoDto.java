package com.desafio.sonner.controller.dto;

import java.math.BigDecimal;

import com.desafio.sonner.modelo.Produto;

public class ProdutoDto {
	
	private Integer id;
	private String codigo;
	private String descricao;
	private BigDecimal valor;
	
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.codigo = produto.getCodigo();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	

}
