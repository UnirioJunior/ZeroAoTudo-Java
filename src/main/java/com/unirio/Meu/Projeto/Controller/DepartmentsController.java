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

import com.unirio.Meu.Projeto.DataTransferObject.DepartmentsDTO;
import com.unirio.Meu.Projeto.Service.DepartmentsService;

@RestController
@RequestMapping(value = "/departments")
@CrossOrigin
public class DepartmentsController {
		
		@Autowired
		private DepartmentsService departamentoService;
		
		@GetMapping
		public List<DepartmentsDTO> listarTodos() {
			return departamentoService.listarTodos();
		}

		@PostMapping
		public void  inserir(@RequestBody DepartmentsDTO user) {
			departamentoService.inserir(user);
		}
		
		@PutMapping
		public DepartmentsDTO alterar(@RequestBody DepartmentsDTO user) {
			return departamentoService.alterar(user);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> excluir(@PathVariable("id") Long id){
			departamentoService.excluir(id);
			return ResponseEntity.ok().build();
		}
}
