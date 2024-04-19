package com.nivaldo.projetoapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivaldo.projetoapi.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Optional<Professor> findByEmail(String email);
}
