package com.kamustiago.kamus.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kamustiago.kamus.dominio.Post;

//Classe dominio Usuario para ser gerenciada, tipo id do tipo String
//conversa com o banco de dados
@Repository
public interface PostRepositorio  extends MongoRepository<Post, String>{

}
