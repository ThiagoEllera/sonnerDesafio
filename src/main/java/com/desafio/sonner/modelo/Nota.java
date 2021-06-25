package com.desafio.sonner.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataCompra;
	private Integer numero;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy="nota", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NotaItem> notaItem;


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

	
}
