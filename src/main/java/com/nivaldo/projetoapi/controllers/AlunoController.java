package com.nivaldo.projetoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivaldo.projetoapi.entities.Aluno;
import com.nivaldo.projetoapi.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping
	public ResponseEntity<List<Aluno>> buscarTodos() {
		List<Aluno> listaAluno = service.buscarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(listaAluno);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id) {
		Aluno response = service.buscarAluno(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> criarAluno(@RequestBody Aluno aluno) {
		String response = service.criarAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> editarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
		String response = service.editarAluno(id, aluno);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirAluno(@PathVariable Long id) {
		String response = service.excluirAluno(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
