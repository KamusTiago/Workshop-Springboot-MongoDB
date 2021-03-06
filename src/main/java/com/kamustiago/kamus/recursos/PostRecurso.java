package com.kamustiago.kamus.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamustiago.kamus.dominio.Post;
import com.kamustiago.kamus.recursos.util.URL;
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
	
/** O metodo de busca sera um parametro, por isso usarei o @RequestParam 
 * se o parametro texto nao for informado, log virá string vazio
 */
	@RequestMapping(value = "/procurartitulo", method = RequestMethod.GET) 
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value= "texto", defaultValue="") String texto) {
		texto = URL.decodificarParam(texto);
		List<Post> lista = servico.buscarPorTitulo(texto);
		
		// metodo retorna uma resposta  objeto user convertido para lista
		return ResponseEntity.ok().body((lista));
	}
	
/** Fiz o tratamento das datas logo apos decodificar o texto da url e caso de erro na conversao da data, ele vai para 
 *  a data padrao do java que é 01/01/1970 e caso dê erro na conversao da data maxima eu vou converter para data atual
 *  do sistema
 */
	@RequestMapping(value = "/procurarvarios", method = RequestMethod.GET) 
	public ResponseEntity<List<Post>> procurarPorVariosCriterios(
			@RequestParam(value= "texto", defaultValue="") String texto,
			@RequestParam(value= "dataMinima", defaultValue="") String dataMinima,
			@RequestParam(value= "dataMaxima", defaultValue="") String dataMaxima) {
		texto = URL.decodificarParam(texto);
		Date minima = URL.converterData(dataMinima, new Date(0L));
		Date maxima = URL.converterData(dataMaxima, new Date());
		
		List<Post> lista = servico.procurarPorVariosCriterios(texto, minima, maxima);
		
		// metodo retorna uma resposta  objeto user convertido para lista
		return ResponseEntity.ok().body((lista));
	}
	
	
}
