package com.kamustiago.kamus.servicos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.dominio.Post;
import com.kamustiago.kamus.repositorio.PostRepositorio;
import com.kamustiago.kamus.servicos.excessao.ObjectNotFoundException;

@Service
public class PostServico {

	@Autowired // instanciando automaticamente
	private PostRepositorio postRepositorioDosPosts;
	
	// implemento o metodo orElse para não ter que colocar o Optional pq a versao 2.0 do spring obriga
	public Post findById(String id) {
		Post user = postRepositorioDosPosts.findById(id).orElse(null);
		if (user == null) {
		throw new ObjectNotFoundException("OBJETO NAO ENCONTRADO");
		}
		return user;
	}
	
	public List<Post> buscarPorTitulo(String texto){
		return postRepositorioDosPosts.procucarPorTitulo(texto);
	}
	
	/** Como as datas sao armazenadas em milisegundos, eu vou fazer a comparacao menor ou igual a data do dia seguinte,
	 * ja que por padrao se eu nao colocar no dia seguinte, so vai contar ate meia noite do dia atual
	 */
	public List<Post> procurarPorVariosCriterios(String texto, Date dataMinima, Date dataMaxima){
		dataMaxima = new Date(dataMaxima.getTime() + 1000 * 60 * 60 * 24);
		return postRepositorioDosPosts.procurarPorVariosCriterios(texto, dataMinima, dataMaxima);
	}
	
}
	
	
	
	

