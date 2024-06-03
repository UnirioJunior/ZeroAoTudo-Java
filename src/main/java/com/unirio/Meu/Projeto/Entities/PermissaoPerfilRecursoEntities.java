package com.unirio.Meu.Projeto.Entities;
import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.DataTransferObject.PermissaoPerfilRecursoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PERMISSAO_PERFIL_RECURSO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntities perfil;
	
	@ManyToOne
	@JoinColumn(name = "ID_RECURSO")
	private RecursoEntities recurso;
	
	public PermissaoPerfilRecursoEntities(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoEntities(permissaoPerfilRecurso.getRecurso());
		}
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
			this.perfil = new PerfilEntities(permissaoPerfilRecurso.getPerfil());
		}	
	}
}