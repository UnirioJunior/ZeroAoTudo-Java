package com.unirio.Meu.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.PerfilUsuarioDTO;
import com.unirio.Meu.Projeto.Entities.PerfilUsuarioEntities;
import com.unirio.Meu.Projeto.Repositories.PerfilUsuarioRepositories;

@Service
public class PerfilUsuarioService {
	@Autowired
	private PerfilUsuarioRepositories perfilUsuarioRepository;

	public List<PerfilUsuarioDTO> listarTodos() {
		List<PerfilUsuarioEntities> usuarios = perfilUsuarioRepository.findAll();
		return usuarios.stream().map(PerfilUsuarioDTO::new).toList();
	}

	public void inserir(PerfilUsuarioDTO usuario) {
		PerfilUsuarioEntities perfilUsuarioEntities = new PerfilUsuarioEntities(usuario);
		perfilUsuarioRepository.save(perfilUsuarioEntities);
	}

	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO usuario) {
		PerfilUsuarioEntities perfilUsuarioEntities = new PerfilUsuarioEntities(usuario);
		return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntities));
	}
	
	public void excluir(Long id) {
		PerfilUsuarioEntities perfilUsuarioEntities = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuarioEntities);
	}
	
	public PerfilUsuarioDTO buscaPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
	}
}
