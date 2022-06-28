package org.generation.LGBT.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")

public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPostagem;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String titulo;
	
	@NotNull
	@Size(min = 1, max = 1000)
	private String textoPost;
	
	@NotNull
	@Size(min = 1, max = 25)
	private String tema;
	
	@NotNull
	private boolean sensivel;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties ({"senha","usuario","comentarios","postagem"})
	private Usuario usuario;
	
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("postagem")
	private List<Comentarios> comentarios;
	
	//Getters e Setters

	public int getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public boolean isSensivel() {
		return sensivel;
	}

	public void setSensivel(boolean sensivel) {
		this.sensivel = sensivel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
	
}
