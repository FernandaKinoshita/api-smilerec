package br.com.fiap.apismilerec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apismilerec.model.Terapeuta;

//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface TerapeutaRepository extends JpaRepository<Terapeuta, Long> {
	
	
	//faz uma query especifica no bd 
	@Query(value="SELECT t FROM Terapeuta t WHERE t.email=?1 or t.cpf=?1 ")
	Terapeuta buscaPorCpfOuEmail(String cpfOuEmail);

	Terapeuta findByEmail(String email);
}
