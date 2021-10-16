package br.com.fiap.apismilerec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	private Date dataNascimento;

	@Column(nullable = false, length = 20)
	private String genero;

	@Column
	@Min(value = 0)
	private int acertos;

	@Column
	@Min(value = 0)
	private int tentativas;

	// Relacionamento: muitos para 1
	@ManyToOne
	private Terapeuta terapeuta;

	// Construtor
	public Paciente() {
	}

	public Paciente(Long id, String nome, Date dataNascimento, String genero, int acertos, int tentativas) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.acertos = acertos;
		this.tentativas = tentativas;

	}
}
