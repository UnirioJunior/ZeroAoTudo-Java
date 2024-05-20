package com.unirio.Meu.Projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"com.unirio.Meu.Projeto.Repositories"})
@EntityScan(basePackages = "com.unirio.Meu.Projeto.Entities")
@SpringBootApplication
public class MeuProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuProjetoApplication.class, args);
	}

}
