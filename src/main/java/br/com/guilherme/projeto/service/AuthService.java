package br.com.guilherme.projeto.service;

import br.com.guilherme.projeto.dto.AcessDTO;
import br.com.guilherme.projeto.dto.AuthenticationDTO;
import br.com.guilherme.projeto.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login (AuthenticationDTO authDTO){

        try {
            // Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

            // Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Busca usuário logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;

        }catch (BadCredentialsException e){

        }
        return new AcessDTO("Acesso negado");

    }
}
