package br.com.guilherme.projeto.repository;

import br.com.guilherme.projeto.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
