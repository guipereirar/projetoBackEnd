package br.com.guilherme.projeto.controller;

import br.com.guilherme.projeto.dto.PerfilUsuarioDTO;
import br.com.guilherme.projeto.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos(){
        return perfilUsuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilUsuario){
        perfilUsuarioService.inserir(perfilUsuario);
    }

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuario){
        return perfilUsuarioService.alterar(perfilUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        perfilUsuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
