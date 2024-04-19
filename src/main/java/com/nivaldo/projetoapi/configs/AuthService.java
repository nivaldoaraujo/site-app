package com.nivaldo.projetoapi.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nivaldo.projetoapi.entities.Professor;
import com.nivaldo.projetoapi.repositories.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService{

	@Autowired
	private ProfessorRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Professor professor = repository.findByEmail(username)
				.orElseThrow(() -> new RuntimeException("Não encontrado"));
		return new User(professor.getUsername(), professor.getPassword(), true, true, true, true, professor.getAuthorities());
	}
}
