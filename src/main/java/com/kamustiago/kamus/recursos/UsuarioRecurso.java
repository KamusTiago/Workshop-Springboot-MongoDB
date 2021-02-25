package com.kamustiago.kamus.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kamustiago.kamus.dominio.Post;
import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.dto.UsuarioDTO;
import com.kamustiago.kamus.servicos.UsuarioServico;

@RestController // recurso rest
@RequestMapping(value = "/usuarios") // caminho do end point
public class UsuarioRecurso {

	
	@Autowired
	private UsuarioServico servico;
	
	/** end point rest no caminho user
	* ResponseEntity<T> foi utilizado para encapsular uma estrutura necessaria para retornar resposta http
	* com posiveis cabeçalhos, erros, etc
	* metodo ok() para instanciar responseentity ja com o codigo de resposta http informando "sucesso"
	 body() vai definir o corpo da resposta a lista que eu montei */
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = servico.findAll();
		
	/** convertendo uma lista de usuario para usuarioDTO com instrucao lambda
	* metodo stream faz conversao para streamer para colecao compativel com expessoes lambda
	* map() vai pegar cada objeto x da lista original e para cada obj que vai ser usuario, retorne new usuario passando o x
	* e voltando o stream para uma lista uso o Collect( collectors.tolist()) */	
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		// metodo retorna agor aum listaDTO 
		return ResponseEntity.ok().body(listaDto);
	}
	
	// para o argumento id do metodo  findById "casar" com o caminho /{id} é necessario a anotacao @PathVariable  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario user = servico.findById(id);
		
		// metodo retorna uma resposta  objeto user convertido para userDTO
		return ResponseEntity.ok().body(new UsuarioDTO(user));
	}
	
	// para que o end point aceite o objeto, uso o @RequestBody, end point para inserir
	@RequestMapping(method = RequestMethod.POST) 
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuarioDto) {		
		Usuario user = servico.fromDTO(usuarioDto);
		user = servico.inserir(user);
		
		// codigo especifico do spring para colocar um cabeçalho com a URL do recurso criado:
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		// o created retorna o codigo 201
		return ResponseEntity.created(uri).build();
	}
	
	// endpoint para deletar por id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servico.deletar(id);
		
		//metodo retorna uma resposta 204 no content
		return ResponseEntity.noContent().build();
	}
	
	//endpoint para fazer atualizacao
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuarioDto, @PathVariable String id) {		
		Usuario user = servico.fromDTO(usuarioDto);
		
		// setei o id da requisicao no metodo update
		user.setId(id);
		user = servico.update(user);
		
		//metodo retorna uma resposta 204 no content
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts",method = RequestMethod.GET) 
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		Usuario user = servico.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}

}
