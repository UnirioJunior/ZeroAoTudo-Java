package com.unirio.Meu.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.PerfilDTO;
import com.unirio.Meu.Projeto.Entities.PerfilEntities;
import com.unirio.Meu.Projeto.Repositories.PerfilRepositories;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepositories perfilRepositories;
	
	public List<PerfilDTO> listarTodos() {
		List<PerfilEntities> perfil = perfilRepositories.findAll();
		return perfil.stream().map(PerfilDTO::new).toList();
	}

	public void inserir(PerfilDTO perfil) {
		PerfilEntities perfilEntities = new PerfilEntities(perfil);
		perfilRepositories.save(perfilEntities);
	}

	public PerfilDTO alterar(PerfilDTO perfil) {
		PerfilEntities perfilEntities = new PerfilEntities(perfil);
		return new PerfilDTO(perfilRepositories.save(perfilEntities));
	}
	
	public void excluir(Long id) {
		PerfilEntities perfil = perfilRepositories.findById(id).get();
		perfilRepositories.delete(perfil);
	}
	
	public PerfilDTO buscaPorId(Long id) {
		return new PerfilDTO(perfilRepositories.findById(id).get());
	}
}
