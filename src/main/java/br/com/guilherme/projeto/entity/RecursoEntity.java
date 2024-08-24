package br.com.guilherme.projeto.entity;

import br.com.guilherme.projeto.dto.RecursoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "recurso")
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String chave;

    public RecursoEntity() {
    }

    public RecursoEntity(RecursoDTO recurso){
        BeanUtils.copyProperties(recurso, this);
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RecursoEntity other = (RecursoEntity) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
