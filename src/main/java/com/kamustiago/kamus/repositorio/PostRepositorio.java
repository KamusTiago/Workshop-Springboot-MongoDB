package com.kamustiago.kamus.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kamustiago.kamus.dominio.Post;

// Classe dominio Usuario para ser gerenciada, tipo id do tipo String
// conversa com o banco de dados
@Repository
public interface PostRepositorio  extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String texto);
	
	
/** Consulta simples, mas com anotação query do mongodb no formato padrao json
 * para eu informar no regex que eu quero utilizar o parametro texto, eu uso "?0" porque é o primeiro parametro
 * do metodo.
 * Utilizo o options "i" porque é o case insensitive
 */
	@Query("{ 'title' : { $regex: ?0, $options:  'i'} }" )
	List<Post> procucarPorTitulo(String texto);
}
