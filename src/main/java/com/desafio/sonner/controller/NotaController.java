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

import com.desafio.sonner.controller.dto.DetalhesNotaDto;
import com.desafio.sonner.controller.dto.NotaDto;
import com.desafio.sonner.controller.form.AtulizacaoNotaForm;
import com.desafio.sonner.controller.form.NotaForm;
import com.desafio.sonner.modelo.Nota;
import com.desafio.sonner.repository.ClienteRepository;
import com.desafio.sonner.repository.NotaRepository;

@RestController
@RequestMapping(value="/nota")
public class NotaController {
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<NotaDto> lista(){
		List<Nota> nota = notaRepository.findAll();	
		return NotaDto.converter(nota);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<NotaDto> cadastrar(@RequestBody @Valid NotaForm form, UriComponentsBuilder uriBuilder) {
		
		Nota nota = form.converter(clienteRepository);
		 notaRepository.save(nota);
		 
		 URI uri = uriBuilder.path("/nota{id}").buildAndExpand(nota.getId()).toUri();
		 return ResponseEntity.created(uri).body(new NotaDto(nota));
	}
	
	@GetMapping("/{id}")
	public DetalhesNotaDto detalhar(@PathVariable Integer id) {
		
		Nota nota = notaRepository.getById(id);
		return new DetalhesNotaDto(nota);		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<NotaDto> atualizar(@PathVariable Integer id, @RequestBody AtulizacaoNotaForm form){
		Nota nota = form.atualizar(id, notaRepository, clienteRepository);
		
		return ResponseEntity.ok(new NotaDto(nota));		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		notaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
