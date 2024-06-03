package com.unirio.Meu.Projeto.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unirio.Meu.Projeto.Entities.UserEntities;

public interface UserRepository extends JpaRepository<UserEntities, Long> {
	
	Optional<UserEntities> findByLogin(String login);
}