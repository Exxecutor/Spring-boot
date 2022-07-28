package br.org.generation.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class Objetivos {
	
	@GetMapping //coloque a informação abaixo no endereço
	public String objetivos() {
		return "Objetivos de aprendizagem dessa semana:"
				+ "✅  BSMs de Estudo de Caso (2: Entregável Urgente, 3: Novas Habilidades Necessárias, 4: Aprender e Compartilhar);\r\n"
				+ "✅  Exercício DER (instruções no exercício na plataforma da Gen);\r\n"
				+ "✅  DER do Projeto Integrador (instruções no exercício na plataforma da Gen);\r\n"
				+ "✅  Exercício de Introdução ao Spring Boot na plataforma da Gen;\r\n"
				+ "✅  Encontro Grupo de Afinidades LGBTQIAPN+;\r\n"
				+ "✅  BSMs de Estudo de Caso (2: Entregável Urgente, 3: Novas Habilidades Necessárias, 4: Aprender e Compartilhar)";
	}

}
