package com.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tb_postagens")



public class Postagem {
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;

    @ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="O atributo título é obrigatório")
	@Size(min=3,max=255,message="O atributo título deve ter entre 3 e 255 caracteres")
	private String titulo;
	@NotBlank(message="O atributo texto é obrigatorio")
	@Size(min=5,max=1000,message="O atributo texto deve ter entre 5 e 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

    public Tema getTema() {
        return this.tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
	

}
