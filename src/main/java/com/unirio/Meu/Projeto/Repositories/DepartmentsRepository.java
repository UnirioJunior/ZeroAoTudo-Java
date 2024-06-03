package com.unirio.Meu.Projeto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unirio.Meu.Projeto.Entities.DepartmentEntities;

public interface DepartmentsRepository extends JpaRepository<DepartmentEntities, Long>{
	
}
