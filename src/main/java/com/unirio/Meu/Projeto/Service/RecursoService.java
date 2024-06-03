package com.unirio.Meu.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.RecursoDTO;
import com.unirio.Meu.Projeto.Entities.RecursoEntities;
import com.unirio.Meu.Projeto.Repositories.RecursoRepositories;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepositories recursoRepository;
	
	public List<RecursoDTO> listarTodos(){
		List<RecursoEntities> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDTO::new).toList();
	}
	
	public void inserir(RecursoDTO recurso) {
		RecursoEntities recursoEntity = new RecursoEntities(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntities recursoEntity = new RecursoEntities(recurso);
		return new RecursoDTO(recursoRepository.save(recursoEntity));
	}
	
	public void excluir(Long id) {
		RecursoEntities recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
	}
	
	public RecursoDTO buscarPorId(Long id) {
		return new RecursoDTO(recursoRepository.findById(id).get());
	}
}