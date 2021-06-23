package com.desafio.sonner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sonner.modelo.NotaItem;

public interface NotaItemRepository extends JpaRepository<NotaItem, Integer> {

}
