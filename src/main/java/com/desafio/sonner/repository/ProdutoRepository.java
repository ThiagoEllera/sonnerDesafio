package com.desafio.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sonner.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Produto findByDescricao(String nomeProduto);

}
