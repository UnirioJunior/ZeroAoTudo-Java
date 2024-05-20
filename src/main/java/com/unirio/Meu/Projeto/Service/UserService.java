package com.unirio.Meu.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unirio.Meu.Projeto.DataTransferObject.UserDTO;
import com.unirio.Meu.Projeto.Entities.UserEntities;
import com.unirio.Meu.Projeto.Repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository usuarioRepository;

	public List<UserDTO> listarTodos() {
		List<UserEntities> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UserDTO::new).toList();
	}

	public void inserir(UserDTO usuario) {
		UserEntities usuarioEntitis = new UserEntities(usuario);
		usuarioRepository.save(usuarioEntitis);
	}

	public UserDTO alterar(UserDTO usuario) {
		UserEntities usuarioEntitis = new UserEntities(usuario);
		return new UserDTO(usuarioRepository.save(usuarioEntitis));
	}
	
	public void excluir(Long id) {
		UserEntities usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UserDTO buscaPorId(Long id) {
		return new UserDTO(usuarioRepository.findById(id).get());
	}
}
