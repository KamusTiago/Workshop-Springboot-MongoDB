package com.kamustiago.kamus.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.repositorio.UsuarioRepositorio;


@Configuration
public class Instanciacao implements CommandLineRunner {

	//Injetando o repositorio do usuario para fazer operacao com banco de dados
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//limpando a colecao no mongoDB
		usuarioRepositorio.deleteAll();
		
		Usuario Tiago = new Usuario(null, "Tiago Silva", "tiagosilva@gmail.com");
		Usuario Alex = new Usuario(null, "Alex jhon", "alex@gmail.com");
		Usuario John = new Usuario(null, "John Tyson", "tysson@gmail.com");
		
		//salvando na colecao de usuarios
		usuarioRepositorio.saveAll(Arrays.asList(Tiago, Alex, John));
		
		
		
	}

}
