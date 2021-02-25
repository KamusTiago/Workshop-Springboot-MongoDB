package com.kamustiago.kamus.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamustiago.kamus.dominio.Post;
import com.kamustiago.kamus.servicos.PostServico;

@RestController // recurso rest
@RequestMapping(value = "/posts") // caminho do end point
public class PostRecurso {

	
	@Autowired
	private PostServico servico;
	
	// para o argumento id do metodo  findById "casar" com o caminho /{id} é necessario a anotacao @PathVariable  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post user = servico.findById(id);
		
		// metodo retorna uma resposta  objeto user convertido para Post
		return ResponseEntity.ok().body((user));
	}
	
	
}
