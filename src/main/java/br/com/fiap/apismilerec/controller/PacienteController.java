
package br.com.fiap.apismilerec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apismilerec.model.Paciente;
import br.com.fiap.apismilerec.repository.PacienteRepository;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/pacientes") // uri padrao para nossa api
public class PacienteController {

	// @ Autowired fornece controle sobre onde e como a ligação entre os beans deve
	// ser realizada
	@Autowired
	PacienteRepository pacienteRepository;

	// Lista o terapeuta no banco de dados
	@GetMapping
	public List<Paciente> lista() {
		return pacienteRepository.findAll();
	}

	// Salva o paciente no banco de dados
	@PostMapping
	@ResponseBody
	public Paciente novo(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	// Exclui um paciente
	@DeleteMapping
	public void deletaPaciente(@RequestBody Paciente paciente) {
		pacienteRepository.delete(paciente);
	}

	// Atualiza um terapeuta
	@PutMapping
	public Paciente atualizaPaciente(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

}
