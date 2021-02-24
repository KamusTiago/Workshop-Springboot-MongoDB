package com.kamustiago.kamus.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamustiago.kamus.dominio.Usuario;

@RestController // recurso rest
@RequestMapping(value = "/usuarios") // caminho do end point
public class UsuarioRecurso {

	
	// end point rest no caminho user
	//ResponseEntity<T> foi utilizado para encapsular uma estrutura necessaria para retornar resposta http
	//com posiveis cabeçalhos, erros, etc
	//metodo ok() para instanciar responseentity ja com o codigo de resposta http informando "sucesso"
	//body() vai definir o corpo da resposta a lista que eu montei
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Usuario>> findAll() {
		Usuario maria = new Usuario("1", "Joao Silva", "joão@gmail.com");
		Usuario carlos = new Usuario("1", "Carlos Shwasnegger", "exterminador@gmail.com");
		Usuario Cruiser = new Usuario("1", "Tom Cana Brava", "canadeacucar@gmail.com");
		List<Usuario> lista = new ArrayList<Usuario>();
		lista.addAll(Arrays.asList(maria, carlos, Cruiser));
		return ResponseEntity.ok().body(lista);
	}

}
