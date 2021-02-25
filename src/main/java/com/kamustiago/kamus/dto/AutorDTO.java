package com.kamustiago.kamus.dto;

import java.io.Serializable;

import com.kamustiago.kamus.dominio.Usuario;

// objetos convertidos em bytes para serem trafegados em rede, gravados em arquivos = Serializable
public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AutorDTO() {
	}
	
	//Construtor com sobrecarga para instanciar a partir do objeto do tipo entidade usuario
	public AutorDTO(Usuario objetoUsuario) {
		id = objetoUsuario.getId();
		nome = objetoUsuario.getNome();
	}

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
}
