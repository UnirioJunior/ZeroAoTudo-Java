package com.unirio.Meu.Projeto.DataTransferObject;



import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.Entities.PerfilUsuarioEntities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioDTO {
		
	private Long id;
	private UserDTO usuario;
	private PerfilDTO perfil;
	
	
	public PerfilUsuarioDTO(PerfilUsuarioEntities perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if (perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UserDTO(perfilUsuario.getUsuario());
		}
		if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.perfil = new PerfilDTO(perfilUsuario.getPerfil());
		}
	}	
	
}