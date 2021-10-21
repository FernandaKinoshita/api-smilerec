package br.com.fiap.apismilerec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.apismilerec.model.Terapeuta;
import br.com.fiap.apismilerec.repository.TerapeutaRepository;

@Controller
public class LoginController {

	@Autowired
	TerapeutaRepository terapeutaRepository;

	@RequestMapping("/login")
	public ResponseEntity<Terapeuta> login(@RequestBody Terapeuta login) {

		Terapeuta terapeuta = terapeutaRepository.findByEmail(login.getEmail());

		if (terapeuta.getSenha().equals(login.getSenha())) {
			return ResponseEntity.ok(terapeuta);
		}

		return ResponseEntity.badRequest().build();
	}

}
