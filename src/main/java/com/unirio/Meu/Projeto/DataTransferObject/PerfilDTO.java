package com.unirio.Meu.Projeto.DataTransferObject;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.Entities.PerfilEntities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {
		
	private Long id;
	private String descricao;
	
	public PerfilDTO(PerfilEntities perfil){
		BeanUtils.copyProperties(perfil, this);
	}
}
