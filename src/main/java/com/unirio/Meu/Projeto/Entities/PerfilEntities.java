package com.unirio.Meu.Projeto.Entities;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.DataTransferObject.PerfilDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_perfil")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilEntities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "perfil_name")
	private String descricao;
	
	public PerfilEntities(PerfilDTO perfil){
		BeanUtils.copyProperties(perfil, this);
	}
}
