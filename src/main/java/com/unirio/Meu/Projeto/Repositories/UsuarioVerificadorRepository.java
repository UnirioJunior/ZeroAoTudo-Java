package com.unirio.Meu.Projeto.Repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unirio.Meu.Projeto.Entities.UsuarioVerificadorEntity;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

	public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
