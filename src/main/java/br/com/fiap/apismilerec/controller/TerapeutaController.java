
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

import br.com.fiap.apismilerec.model.Terapeuta;
import br.com.fiap.apismilerec.repository.TerapeutaRepository;

//import static br.com.fiap.apismilerec.filter.TerapeutaFilter.validaSeTerapeutaExiste;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/terapeutas") //uri padrao para nossa api
public class TerapeutaController {
	
	//@ Autowired fornece controle sobre onde e como a ligação entre os beans deve ser realizada
	@Autowired
	TerapeutaRepository terapeutaRepository;
	
	
	//Lista o terapeuta no banco de dados
	@GetMapping
	public List<Terapeuta> lista(){
		return terapeutaRepository.findAll();
	}
	
	
	//Salva o terapeuta no banco de dados
	@PostMapping
	@ResponseBody	
	public Terapeuta novo(@RequestBody Terapeuta terapeuta){ 		
		return terapeutaRepository.save(terapeuta);
	}
	
	//Exclui um terapeuta
	@DeleteMapping
	public void deletaTerapeuta(@RequestBody Terapeuta terapeuta) {
		terapeutaRepository.delete(terapeuta);
	}
	
	
	//Atualiza um terapeuta
	@PutMapping
	public Terapeuta atualizaTerapeuta(@RequestBody Terapeuta terapeuta) {
		return terapeutaRepository.save(terapeuta);
	}	
	
}
