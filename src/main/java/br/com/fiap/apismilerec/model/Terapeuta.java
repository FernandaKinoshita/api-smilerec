package br.com.fiap.apismilerec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_TERAPEUTA")
public class Terapeuta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

		
	@Column(nullable = false, length = 50)
	private String nome;

		
	@Email 
	@Column(nullable = false, length = 40, unique=true)
	private String email;

		
	@CPF
	@Column(nullable = false, length = 11, unique=true)
	private String cpf;

	
	@Column(nullable = false, length = 8)
	private String senha;

	
	
	//Construtor
	public Terapeuta() {		
	}

	public Terapeuta(Long id, String nome, String email, String cpf, String senha) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

}
