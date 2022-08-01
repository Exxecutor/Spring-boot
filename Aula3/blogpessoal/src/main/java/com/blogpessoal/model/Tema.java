package com.blogpessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="tb_temas")
public class Tema {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="O atributo descrição é obrigatório")
	@Size(min=3,max=255,message="O atributo descrição deve ter entre 3 e 255 caracteres")
	private String descricao;
	
	//@OneToMany(mappedBy = "tema")  // nome do objeto tema na classe postagens
	//private List<Postagem> postagens;

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
