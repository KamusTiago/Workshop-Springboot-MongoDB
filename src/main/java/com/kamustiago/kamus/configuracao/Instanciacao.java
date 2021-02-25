package com.kamustiago.kamus.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kamustiago.kamus.dominio.Post;
import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.dto.AutorDTO;
import com.kamustiago.kamus.repositorio.PostRepositorio;
import com.kamustiago.kamus.repositorio.UsuarioRepositorio;


@Configuration
public class Instanciacao implements CommandLineRunner {

	//Injetando o repositorio do usuario para fazer operacao com banco de dados
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PostRepositorio postRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// INSTANCIANDO A DATA NO HORARIO DE GREENWITCH / HORARIO DE LONDRES
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		//limpando a colecao no mongoDB
		usuarioRepositorio.deleteAll();
		postRepositorio.deleteAll();
		
		Usuario Tiago = new Usuario(null, "Tiago Silva", "tiagosilva@gmail.com");
		Usuario Alex = new Usuario(null, "Alex jhon", "alex@gmail.com");
		Usuario John = new Usuario(null, "John Tyson", "tysson@gmail.com");
		
		//salvando na colecao de usuarios
		usuarioRepositorio.saveAll(Arrays.asList(Tiago, Alex, John));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP", new AutorDTO(Alex));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz", new AutorDTO(Alex)); 
		
		//salvando na colecao de posts
		postRepositorio.saveAll(Arrays.asList(post1, post2));
		
		//salvando na colecao de usuarios
		usuarioRepositorio.saveAll(Arrays.asList(Tiago, Alex, John));
		
		
		
	}

}
