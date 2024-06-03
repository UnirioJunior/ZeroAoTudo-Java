package com.unirio.Meu.Projeto.Entities;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.unirio.Meu.Projeto.DataTransferObject.UserDTO;
import com.unirio.Meu.Projeto.Entities.enums.TipoSituacaoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, name = "User_name")
	private String name;
	@Column(nullable = false, name = "User_login")
	private String login;
	@Column(nullable = false, unique = true, name = "User_email")
	private String email;
	@Column(nullable = false, name = "User_senha")
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "User_situacao")
	private TipoSituacaoUsuario situacao;
	
	public UserEntities(UserDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntities department;

	public UserEntities() {
	}
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoSituacaoUsuario getSituacao() {
		return situacao;
	}

	public void setSituacao(TipoSituacaoUsuario situacao) {
		this.situacao = situacao;
	}
	public DepartmentEntities getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntities department) {
		this.department = department;
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
		UserEntities other = (UserEntities) obj;
		return Objects.equals(id, other.id);
	}
	
}