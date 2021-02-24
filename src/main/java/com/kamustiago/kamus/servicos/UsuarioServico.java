package com.kamustiago.kamus.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.dominio.Usuario;
import com.kamustiago.kamus.dto.UsuarioDTO;
import com.kamustiago.kamus.repositorio.UsuarioRepositorio;
import com.kamustiago.kamus.servicos.excessao.ObjectNotFoundException;

@Service
public class UsuarioServico {

	@Autowired // instanciando automaticamente
	private UsuarioRepositorio repositorioDoUsuario;
	
	public List<Usuario> findAll(){
		return repositorioDoUsuario.findAll();
	
	}
	
	// implemento o metodo orElse para não ter que colocar o Optional pq a versao 2.0 do spring obriga
	public Usuario findById(String id) {
		Usuario user = repositorioDoUsuario.findById(id).orElse(null);
		if (user == null) {
		throw new ObjectNotFoundException("OBJETO NAO ENCONTRADO");
		}
		return user;
	}
	
	// metodo para inserir usando o post
	public Usuario inserir(Usuario user) {
		return repositorioDoUsuario.insert(user);
	}
	
	//metodo para deletar usando o delete
	public void deletar(String id) {
		findById(id);
		repositorioDoUsuario.deleteById(id);
	}
		
	// metodo update para atualizar usuario
	public Usuario update(Usuario user) {
		// Busco o objeto original no banco de dados
		Usuario usuarioBuscadoNoBancoDeDados = repositorioDoUsuario.findById(user.getId()).orElse(null);
		updateDados(usuarioBuscadoNoBancoDeDados , user);
		
		// salvo no banco de dados o novo usuario = repositorioDoUsuario.save
		return repositorioDoUsuario.save(usuarioBuscadoNoBancoDeDados);
	}
	
	private void updateDados(Usuario usuarioBuscadoNoBancoDeDados, Usuario user) {
		usuarioBuscadoNoBancoDeDados.setNome(user.getNome());
		usuarioBuscadoNoBancoDeDados.setEmail(user.getEmail());	
	}

	// metodo para pegar um dto e instanciar um usuario
	public Usuario fromDTO(UsuarioDTO usuarioDto) {
		return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getEmail());
	}
	
	
}
	
	
	
	

