package com.kamustiago.kamus.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.servicos.UsuarioServico;

@RestController // recurso rest
@RequestMapping(value = "/usuarios") // caminho do end point
public class UsuarioRecurso {

	
	@Autowired
	private UsuarioServico servico;
	
	// end point rest no caminho user
	//ResponseEntity<T> foi utilizado para encapsular uma estrutura necessaria para retornar resposta http
	//com posiveis cabeçalhos, erros, etc
	//metodo ok() para instanciar responseentity ja com o codigo de resposta http informando "sucesso"
	//body() vai definir o corpo da resposta a lista que eu montei
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}

}
