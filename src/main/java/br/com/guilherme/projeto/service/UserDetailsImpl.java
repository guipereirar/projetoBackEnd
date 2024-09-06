package br.com.guilherme.projeto.service;

import br.com.guilherme.projeto.entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;


    public UserDetailsImpl(Collection<? extends GrantedAuthority> authorities, String email, String username, String name, Long id, String password) {
        this.authorities = authorities;
        this.email = email;
        this.username = username;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public static UserDetailsImpl build(UsuarioEntity usuario){
        return new UserDetailsImpl(
                new ArrayList<>(),
                usuario.getEmail(),
                usuario.getLogin(),
                usuario.getNome(),
                usuario.getId(),
                usuario.getSenha()
                );
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
