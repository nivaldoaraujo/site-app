package com.nivaldo.projetoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivaldo.projetoapi.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

}
