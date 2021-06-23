package com.desafio.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sonner.modelo.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>  {

	Nota findByNumero(Integer numeroNota);

}
