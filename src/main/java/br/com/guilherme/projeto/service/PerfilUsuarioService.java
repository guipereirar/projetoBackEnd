package br.com.guilherme.projeto.service;

import br.com.guilherme.projeto.dto.PerfilUsuarioDTO;
import br.com.guilherme.projeto.entity.PerfilUsuarioEntity;
import br.com.guilherme.projeto.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuarioDTO> listarTodos(){
        List<PerfilUsuarioEntity> perfisUsuario = perfilUsuarioRepository.findAll();
        return perfisUsuario.stream().map(PerfilUsuarioDTO::new).toList();
    }

    public void inserir(PerfilUsuarioDTO perfisUsuario){
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfisUsuario);
        perfilUsuarioRepository.save(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario){
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
    }

    public void excluir(Long id){
        PerfilUsuarioEntity perfilUsuarioEntity = perfilUsuarioRepository.findById(id).get();
        perfilUsuarioRepository.delete(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO buscarPorId(Long id){
        return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
    }
}
