package com.unirio.Meu.Projeto.Entities;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.DataTransferObject.PerfilDTO;
import com.unirio.Meu.Projeto.DataTransferObject.PerfilUsuarioDTO;
import com.unirio.Meu.Projeto.DataTransferObject.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tb_perfil_usuario")
@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioEntities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UserEntities usuario;
	
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private PerfilEntities perfil;
	
	public PerfilUsuarioEntities(PerfilUsuarioDTO perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if (perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UserEntities(perfilUsuario.getUsuario());
		}
		if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.perfil = new PerfilEntities(perfilUsuario.getPerfil());
		}
	}	

}
