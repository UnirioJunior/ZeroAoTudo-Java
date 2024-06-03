package com.unirio.Meu.Projeto.Entities;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.DataTransferObject.RecursoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Recurso")
public class RecursoEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String chave;
	
	public RecursoEntities() {
	
	}

	public RecursoEntities(RecursoDTO recurso) {
		BeanUtils.copyProperties(recurso, this);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecursoEntities other = (RecursoEntities) obj;
		return Objects.equals(id, other.id);
	}	
}
