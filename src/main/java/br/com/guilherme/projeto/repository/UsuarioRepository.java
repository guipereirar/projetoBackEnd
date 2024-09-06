package br.com.guilherme.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme.projeto.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    Optional<UsuarioEntity> findByLogin(String login);
}
