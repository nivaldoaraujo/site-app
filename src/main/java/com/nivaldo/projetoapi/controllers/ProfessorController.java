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

import com.nivaldo.projetoapi.entities.Professor;
import com.nivaldo.projetoapi.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> buscarTodos() {
		List<Professor> listaProfessor = service.buscarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(listaProfessor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> buscarProfessor(@PathVariable Long id) {
		Professor response = service.buscarProfessor(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> criarProfessor(@RequestBody Professor professor) {
		String response = service.criarProfessor(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> editarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		String response = service.editarProfessor(id, professor);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirProfessor(@PathVariable Long id) {
		String response = service.excluirProfessor(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
