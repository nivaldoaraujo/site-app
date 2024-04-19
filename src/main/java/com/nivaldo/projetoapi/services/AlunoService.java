package com.nivaldo.projetoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivaldo.projetoapi.entities.Aluno;
import com.nivaldo.projetoapi.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public List<Aluno> buscarTodos() {
		return repository.findAll();
	}

	public Aluno buscarAluno(Long id) {
		Optional<Aluno> optionalAluno = repository.findById(id);
		return optionalAluno.orElseThrow(() -> new RuntimeException());
	}

	public String criarAluno(Aluno aluno) {
		repository.save(aluno);
		return "Aluno cadastrado com sucesso!";
	}

	public String editarAluno(Long id, Aluno aluno) {
		Optional<Aluno> optionalAluno = repository.findById(id);

		if(optionalAluno.isEmpty()) {
			return "Aluno não encontrado";
		}
		
		Aluno alunoExistente = optionalAluno.get();
		alunoExistente.setNome(aluno.getNome());
		alunoExistente.setEmail(aluno.getEmail());
		alunoExistente.setProfessor(aluno.getProfessor());

		repository.save(alunoExistente);
		return "Informações do aluno editadas com sucesso!";
	}
	
	public String excluirAluno(Long id) {
		Optional<Aluno> optionalAluno = repository.findById(id);
		
		if(optionalAluno.isEmpty()) {
			return "Aluno não encontrado";
		}
		
		repository.delete(optionalAluno.get());
		return "Aluno excluído com sucesso!";
	}
}
