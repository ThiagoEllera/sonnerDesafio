package com.desafio.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sonner.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente getByNome(String nomeCliente);

}
