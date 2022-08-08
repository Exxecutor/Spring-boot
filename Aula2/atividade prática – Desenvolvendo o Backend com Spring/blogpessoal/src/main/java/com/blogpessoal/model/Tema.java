package src.main.java.com.blogpessoal.model;


public class Tema {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="O atributo descrição é obrigatório")
	@Size(min=3,max=255,message="O atributo descrição deve ter entre 3 e 255 caracteres")
	private String Descricao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
