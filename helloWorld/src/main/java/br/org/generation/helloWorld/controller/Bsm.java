package br.org.generation.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bsm")
public class Bsm {
	
	@GetMapping //coloque a informação abaixo no endereço
	public String bsm() {
		return "PT - BSM-GM - Mentalidade de Crescimento\r\n"
				+ "PT - BSM-P - Persistência\r\n"
				+ "PT - BSM-P - Persistência\r\n"
				+ "PT - BSM-PR - Responsabilidade Pessoal\r\n"
				+ "PT - BSM-PR - Responsabilidade Pessoal\r\n"
				+ "PT - BSM-FO - Orientação ao Futuro\r\n"
				+ "PT - BSM-FO - Orientação ao Futuro\r\n"
				+ "PT - BSM-C - Comunicação\r\n"
				+ "PT - BSM-C - Comunicação\r\n"
				+ "PT - BSM-OD - Orientação ao Detalhe\r\n"
				+ "PT - BSM-OD - Orientação ao Detalhe\r\n"
				+ "PT - BSM-PA - Proatividade\r\n"
				+ "PT - BSM-PA - Proatividade\r\n"
				+ "PT - BSM-T - Trabalho em Equipe\r\n"
				+ "PT - BSM-T - Trabalho em Equipe\r\n"
				+ "PT - C-GG - Dar e Receber\r\n"
				+ "PT - C-GG - Dar e Receber\r\n"
				+ "PT - SA-CS1 - Estudo de Caso 1: Força de Trabalho Distribuída\r\n"
				+ "PT - SA-CS1 - Estudo de Caso 1: Força de Trabalho Distribuída\r\n"
				+ "PT - SA-CS2 - Estudo de Caso 2: Entregável Urgente\r\n"
				+ "PT - SA-CS2 - Estudo de Caso 2: Entregável Urgente\r\n"
				+ "PT - SA-CS3 - Estudo de Caso 3: Novas Habilidades Necessárias\r\n"
				+ "PT - SA-CS3 - Estudo de Caso 3: Novas Habilidades Necessárias\r\n"
				+ "PT - SA-CS4 - Estudo de Caso 4: Aprender e Compartilhar\r\n"
				+ "PT - SA-CS4 - Estudo de Caso 4: Aprender e Compartilhar\r\n"
				+ "PT - SSM-TM - Gestão do Tempo\r\n"
				+ "PT - SSM-TM - Gestão do Tempo\r\n"
				+ "PT - SSM-IV - Introdução à VIA e a Descoberta das Forças de Caráter VIA\r\n"
				+ "PT - SSM-IV - Introdução à VIA e a Descoberta das Forças de Caráter VIA\r\n"
				+ "PT - SSM-RLW - Maximizar a Aprendizagem Online e o Trabalho Remoto\r\n"
				+ "PT - SSM-RLW - Maximizar a Aprendizagem Online e o Trabalho Remoto";
	}
}
