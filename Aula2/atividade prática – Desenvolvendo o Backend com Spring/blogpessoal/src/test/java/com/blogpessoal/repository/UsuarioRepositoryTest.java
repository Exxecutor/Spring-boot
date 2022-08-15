package com.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L,"Rafael Silva","rafael@teste.com","12345678","https://i.imgur.com/FETvs2O.jpg"));
		usuarioRepository.save(new Usuario(0L,"Eduardo","eduardo@teste.com","12345678","https://i.imgur.com/NtyGneo.jpg"));
		usuarioRepository.save(new Usuario(0L,"Jorge","jorge@teste.com","12345678","https://i.imgur.com/mB3VM2N.jpg"));
		usuarioRepository.save(new Usuario(0L,"Alberto","alberto@teste.com","12345678","https://i.imgur.com/JR7kUFU.jpg"));
		
	}
	
	@Test
	@DisplayName("Retorna 1 Usuario")
	public void deveretornarUsuario() {
		Optional<Usuario> usuario=usuarioRepository.findByUsuario("rafael@teste.com");
		assertTrue(usuario.get().getUsuario().equals("rafael@teste.com"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3,listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Rafael Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Jorge"));
		assertTrue(listaDeUsuarios.get(2).getUsuario().equals("alberto@teste.com"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}
