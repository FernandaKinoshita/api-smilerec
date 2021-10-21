package br.com.fiap.apismilerec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apismilerec.model.Paciente;

//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	Optional<Paciente> findById(Long id);
	
	//JPQL=Query dentro do Java. 
	//Seleciona lista de pacientes por id do terapeuta
	//Inner Join pelo id do terapeuta buscando uma lista de pacientes
	@Query(value = "SELECT p FROM Paciente p JOIN FETCH p.terapeuta WHERE p.terapeuta.id = ?1")
	List<Paciente> findByIdTerapeuta(Long idTerapeuta);
	
	
}

