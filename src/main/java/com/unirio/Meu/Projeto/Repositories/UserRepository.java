package com.unirio.Meu.Projeto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unirio.Meu.Projeto.Entities.UserEntities;

public interface UserRepository extends JpaRepository<UserEntities, Long> {

}