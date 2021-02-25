package com.kamustiago.kamus.dto;

import java.io.Serializable;
import java.util.Date;

// objetos convertidos em bytes para serem trafegados em rede, gravados em arquivos = Serializable
public class ComentarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;
	private AutorDTO autor;
	
	public ComentarioDTO() {
		
	}
	
	// Construtor com sobrecarga para instanciar a partir do objeto do tipo entidade AUTOR
	public ComentarioDTO(String texto, Date data, AutorDTO autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	
}
