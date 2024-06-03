package com.unirio.Meu.Projeto.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unirio.Meu.Projeto.DataTransferObject.AuthenticationDTO;
import com.unirio.Meu.Projeto.DataTransferObject.UserDTO;
import com.unirio.Meu.Projeto.Service.AuthService;
import com.unirio.Meu.Projeto.Service.UserService;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService usuarioService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
		return ResponseEntity.ok(authService.login(authDto));
	}
	
	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UserDTO novoUsuario){
		usuarioService.inserirNovoUsuario(novoUsuario);
	}
	
	@GetMapping(value = "/verificarCadastro/{uuid}")
	public String verificarCadastro(@PathVariable("uuid") String uuid) {
		return usuarioService.verificarCadastro(uuid);
	}
	
}