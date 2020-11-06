package br.com.itau.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.model.Contador;
@Repository
public interface ContadorRepository extends JpaRepository<Contador, Long> {

	Optional<Contador> findFirstByUrlOrderByIdDesc(String path);

}
