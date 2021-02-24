package com.kamustiago.kamus.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.dto.UsuarioDTO;
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
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = servico.findAll();
		
		//convertendo uma lista de usuario para usuarioDTO com instrucao lambda
		//metodo stream faz conversao para streamer para colecao compativel com expessoes lambda
		//map() vai pegar cada objeto x da lista original e para cada obj que vai ser usuario, retorne new usuario passando o x
		// e voltando o stream para uma lista uso o Collect( collectors.tolist())	
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		//metodo retorna agor aum listaDTO
		return ResponseEntity.ok().body(listaDto);
	}

}
