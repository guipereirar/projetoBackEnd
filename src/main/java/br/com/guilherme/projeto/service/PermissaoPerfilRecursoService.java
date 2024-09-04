package br.com.guilherme.projeto.service;

import br.com.guilherme.projeto.dto.PermissaoPerfilRecursoDTO;
import br.com.guilherme.projeto.entity.PermissaoPerfilRecursoEntity;
import br.com.guilherme.projeto.repository.PermissaoPerfilRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {

    @Autowired
    private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;

    public List<PermissaoPerfilRecursoDTO> listarTodos(){
        List<PermissaoPerfilRecursoEntity> permissaoPerfisRecurso = permissaoPerfilRecursoRepository.findAll();
        return permissaoPerfisRecurso.stream().map(PermissaoPerfilRecursoDTO::new).toList();
    }

    public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
        permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
    }

    public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
    }

    public void excluir(Long id){
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = permissaoPerfilRecursoRepository.findById(id).get();
        permissaoPerfilRecursoRepository.delete(permissaoPerfilRecursoEntity);
    }

    public PermissaoPerfilRecursoDTO buscarPorId(Long id){
        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.findById(id).get());
    }


}
