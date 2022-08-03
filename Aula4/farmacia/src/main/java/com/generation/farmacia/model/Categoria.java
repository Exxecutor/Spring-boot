package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_categorias")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="O atributo descrição é obrigatório")
	@Size(min=3,max=255,message="O atributo descrição deve ter entre 3 e 255 caracteres")
	private String descricao;
	
	@OneToMany(mappedBy="categoria",cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
		}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}
}