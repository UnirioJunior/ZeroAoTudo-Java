package com.unirio.Meu.Projeto.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.PermissaoPerfilRecursoDTO;
import com.unirio.Meu.Projeto.Entities.PermissaoPerfilRecursoEntities;
import com.unirio.Meu.Projeto.Repositories.PermissaoPerfilRecursoRepositories;



@Service
public class PermissaoPerfilRecursoService {

	@Autowired
	private PermissaoPerfilRecursoRepositories permissaoPerfilRecursoRepository;
	
	public List<PermissaoPerfilRecursoDTO> listarTodos(){
		List<PermissaoPerfilRecursoEntities> permissaoPerfilRecusos = permissaoPerfilRecursoRepository.findAll();
		return permissaoPerfilRecusos.stream().map(PermissaoPerfilRecursoDTO::new).toList();
	}
	
	public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntities permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntities(permissaoPerfilRecurso);
		permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
	}
	
	public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntities permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntities(permissaoPerfilRecurso);
		return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
	}
	
	public void excluir(Long id) {
		PermissaoPerfilRecursoEntities permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findById(id).get();
		permissaoPerfilRecursoRepository.delete(permissaoPerfilRecurso);
	}
	
	public PermissaoPerfilRecursoDTO buscarPorId(Long id) {
		return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.findById(id).get());
	}
}
