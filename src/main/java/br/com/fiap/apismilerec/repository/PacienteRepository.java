package br.com.fiap.apismilerec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apismilerec.model.Paciente;

//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

//	// faz uma query específica no bd
//	@Query(value = "SELECT p FROM Paciente p WHERE p.nome=?1 or p.dataNascimento=?1 ")
//	Paciente buscaPorNomeOuDataNascimento(String nomeOuDataNascimento);
//}
}

