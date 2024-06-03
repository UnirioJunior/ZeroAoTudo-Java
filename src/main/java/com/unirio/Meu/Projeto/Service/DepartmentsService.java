package com.unirio.Meu.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.DepartmentsDTO;
import com.unirio.Meu.Projeto.Entities.DepartmentEntities;
import com.unirio.Meu.Projeto.Repositories.DepartmentsRepository;

@Service
public class DepartmentsService {
	
	@Autowired
	private DepartmentsRepository departmentsRepositories;
	
	public List<DepartmentsDTO> listarTodos() {
		List<DepartmentEntities> departamentos = departmentsRepositories.findAll();
		return departamentos.stream().map(DepartmentsDTO::new).toList();
	}

	public void inserir(DepartmentsDTO departamento) {
		DepartmentEntities departamentosEntities = new DepartmentEntities(departamento);
		departmentsRepositories.save(departamentosEntities);
	}

	public DepartmentsDTO alterar(DepartmentsDTO departamento) {
		DepartmentEntities departamentosEntities = new DepartmentEntities(departamento);
		return new DepartmentsDTO(departmentsRepositories.save(departamentosEntities));
	}
	
	public void excluir(Long id) {
		DepartmentEntities departamento = departmentsRepositories.findById(id).get();
		departmentsRepositories.delete(departamento);
	}
	
	public DepartmentsDTO buscaPorId(Long id) {
		return new DepartmentsDTO(departmentsRepositories.findById(id).get());
	}
}
