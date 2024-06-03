package com.unirio.Meu.Projeto.DataTransferObject;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.Entities.DepartmentEntities;

public class DepartmentsDTO {

	private Long id;
	private String name;
	
	public DepartmentsDTO(DepartmentEntities departamento) {
		BeanUtils.copyProperties(departamento, this);
	}
	
	public DepartmentsDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
