package br.com.guilherme.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
