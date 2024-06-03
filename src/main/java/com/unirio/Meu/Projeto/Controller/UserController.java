package com.unirio.Meu.Projeto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unirio.Meu.Projeto.DataTransferObject.UserDTO;
import com.unirio.Meu.Projeto.Service.UserService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UserController{

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDTO> listarTodos() {
		return userService.listarTodos();
	}
	
	@PostMapping
	public void  inserir(@RequestBody UserDTO user) {
		userService.inserir(user);
	}
	
	@PutMapping
	public UserDTO alterar(@RequestBody UserDTO user) {
		return userService.alterar(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id){
		userService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
