package com.kamustiago.kamus.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.repositorio.UsuarioRepositorio;
import com.kamustiago.kamus.servicos.excessao.ObjectNotFoundException;

@Service
public class UsuarioServico {

	@Autowired //instanciando automaticamente
	private UsuarioRepositorio repositorioDoUsuario;
	
	public List<Usuario> findAll(){
		return repositorioDoUsuario.findAll();
	
	}
	
	//implemento o metodo orElse para não ter que colocar o Optional pq a versao 2.0 do spring obriga
	public Usuario findById(String id) {
		Usuario user = repositorioDoUsuario.findById(id).orElse(null);
		if (user == null) {
		throw new ObjectNotFoundException("OBJETO NAO ENCONTRADO");
		}
		return user;
	}
}
	
	
	
	

