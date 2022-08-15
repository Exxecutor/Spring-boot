package com.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.blogpessoal.model.Usuario;
import com.blogpessoal.repository.UsuarioRepository;
import com.blogpessoal.service.UsuarioService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um Usuário")
	public void deveCriarUmUsuario() {
		HttpEntity<Usuario> requisicao= new HttpEntity<Usuario>(new Usuario(0L,"Zezinho Romeu","zezinho@email.com","12345678","https://i.imgur.com/FETvs2O.jpg"));
		
		ResponseEntity<Usuario> resposta=testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao, Usuario.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(),resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsuario(),resposta.getBody().getUsuario());
	}
	@Test
	@Order(2)
	@DisplayName("Não deve permitir duplicação de um Usuário")
	public void naoDeveDuplicarUsuario() {
		usuarioService.cadastrarUsuario(new Usuario(0L,"Mariano Carlos","url/aleatorio2","marcar@email.com","987654321"));
		
		HttpEntity<Usuario> requisicao= new HttpEntity<Usuario>(new Usuario(0L,"Mariano Carlos","url/aleatorio2","marcar@email.com","987654321"));
		ResponseEntity<Usuario> resposta=testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao, Usuario.class);
		assertEquals(HttpStatus.BAD_REQUEST,resposta.getStatusCode());
	}
	@Test
	@Order(3)
	@DisplayName("Alterar um Usuário")
	public void deveAtualizarUmUsuario() {
		Optional<Usuario> usuarioCreate = usuarioService.cadastrarUsuario(new Usuario(0L,"Juliana","url/aleatorio3","julana@email.com","blabla"));
		Usuario usuarioUpdate= new Usuario(usuarioCreate.get().getId(),"Juliana","url/aleatorio3","julana@email.com","blabla");
		HttpEntity<Usuario> requisicao= new HttpEntity<Usuario>(usuarioUpdate);
		
		ResponseEntity<Usuario> resposta= testRestTemplate
				.withBasicAuth("root","root")
				.exchange("/usuarios/atualizar",HttpMethod.PUT,requisicao,Usuario.class);
			
			assertEquals(HttpStatus.OK,resposta.getStatusCode());
			assertEquals(requisicao.getBody().getNome(),resposta.getBody().getNome());
			assertEquals(requisicao.getBody().getFoto(),resposta.getBody().getFoto());
			assertEquals(requisicao.getBody().getUsuario(),resposta.getBody().getUsuario());
	}
	
	@Test
	@Order(4)
	@DisplayName("Listar todos os Usuários")
	public void deveMostrarTodosUsuarios() {
		usuarioService.cadastrarUsuario(new Usuario(0L,"Joaozinho","url/aleatorio4","jozinho@email.com","blabla2"));
		
		usuarioService.cadastrarUsuario(new Usuario(0L,"Little Richard","url/aleatorio5","richardinho@email.com","blabla3"));
		
		ResponseEntity<Usuario> resposta= testRestTemplate
				.withBasicAuth("root","root")
				.exchange("/usuarios/all",HttpMethod.GET,null,Usuario.class);
		
		assertEquals(HttpStatus.OK,resposta.getStatusCode());
	}
}
