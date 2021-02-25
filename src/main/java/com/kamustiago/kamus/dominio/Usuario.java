package com.kamustiago.kamus.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

// objetos convertidos em bytes para serem trafegados em rede, gravados em arquivos = Serializable
// @Document para corresponder uma colecao mongodb, colecao user

@Document(collection="user")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// atributos da classe usuario
	@Id //chave
	private String id;
	private String nome;
	private String email;
	
	/** para evitar que o trafego de dados na rede seja sobrecarregado por requisicoes, ja que iria trazer todos os usuarios
	 * e seus posts, eu coloco o lazy = true para garantir que os posts sejam carregados apenas se eu explicitamente acessá-los
	 */
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>(); // Por boas praticas eu ja inicio a lista aqui
	
	// construtor padrao 
	public Usuario() {		
	}

	// construtor com argumentos
	public Usuario(String id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	// Comparacao apenas por id com hashCod and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
