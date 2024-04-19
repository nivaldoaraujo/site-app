package com.nivaldo.projetoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nivaldo.projetoapi.entities.Professor;
import com.nivaldo.projetoapi.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> buscarTodos() {
		return repository.findAll();
	}
	
	public Professor buscarProfessor(Long id) {
		Optional<Professor> optionalProfessor = repository.findById(id);
		return optionalProfessor.orElseThrow(() -> new RuntimeException());
	}
	
	public String criarProfessor(Professor professor) {
		professor.setSenha(new BCryptPasswordEncoder().encode(professor.getSenha()));
		repository.save(professor);
		return "Professor cadastrado com sucesso!";
	}
	
	public String editarProfessor(Long id, Professor professor) {
		Optional<Professor> optionalProfessor = repository.findById(id);
		
		if(optionalProfessor.isEmpty()) {
			return "Professor não encontrado";
		}
		
		Professor professorExistente = optionalProfessor.get();
		professorExistente.setNome(professor.getNome());
		professorExistente.setEmail(professor.getEmail());
		professorExistente.setSenha(professor.getSenha());
		
		repository.save(professorExistente);
		return "Informações do professor editadas com sucesso!";
	}
	
	public String excluirProfessor(Long id) {
		Optional<Professor> optionalProfessor = repository.findById(id);
		
		if(optionalProfessor.isEmpty()) {
			return "Professor não encontrado";
		}
		
		repository.delete(optionalProfessor.get());
		return "Professor excluído com sucesso!";
	}
}
