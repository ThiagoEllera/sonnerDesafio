package com.desafio.sonner.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCompra;
	private Integer numero;
	
	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy="nota", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NotaItem> notaItem;

	public Nota() {
		
	}

	public Nota(Integer numero, Date dataCompra, Cliente cliente) {
		this.numero = numero;
		this.dataCompra = dataCompra;
		this.cliente = cliente;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<NotaItem> getNotaItem() {
		return notaItem;
	}

	public void setNotaItem(List<NotaItem> notaItem) {
		this.notaItem = notaItem;
	}

	
}
