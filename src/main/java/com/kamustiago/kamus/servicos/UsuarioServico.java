package com.kamustiago.kamus.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired //instanciando automaticamente
	private UsuarioRepositorio repositorioDoUsuario;
	
	public List<Usuario> findAll(){
		return repositorioDoUsuario.findAll();
	
	}	
}
	
	

