package com.desafio.sonner.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.sonner.controller.dto.ProdutoDto;
import com.desafio.sonner.controller.form.ProdutoForm;
import com.desafio.sonner.modelo.Produto;
import com.desafio.sonner.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDto> lista(){
		List<Produto> produto = produtoRepository.findAll();	
		return ProdutoDto.converter(produto);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		
		Produto produto = form.converter();
		produtoRepository.save(produto);
		 
		 URI uri = uriBuilder.path("/produto{id}").buildAndExpand(produto.getId()).toUri();
		 return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
	@GetMapping("/{id}")
	public ProdutoDto detalhar(@PathVariable Integer id) {
		
		Produto produto = produtoRepository.getById(id);
		return new ProdutoDto(produto);		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Integer id, @RequestBody ProdutoForm form){
		Produto produto = form.atualizar(id, produtoRepository);
		
		return ResponseEntity.ok(new ProdutoDto(produto));		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		produtoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
