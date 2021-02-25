package com.kamustiago.kamus.dto;

import java.io.Serializable;

import com.kamustiago.kamus.dominio.Usuario;

// objetos convertidos em bytes para serem trafegados em rede, gravados em arquivos = Serializable
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String email;
	
	public UsuarioDTO() {
		
	}
	
	// Construtor com sobrecarga para instanciar a partir do objeto do tipo entidade usuario
	public UsuarioDTO(Usuario objetoDoTipoUsuario) {	
		id = objetoDoTipoUsuario.getId();
		nome = objetoDoTipoUsuario.getNome();
		email = objetoDoTipoUsuario.getEmail();		
	}

	// getters e setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
