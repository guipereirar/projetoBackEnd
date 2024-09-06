package br.com.guilherme.projeto.controller;

import br.com.guilherme.projeto.dto.AuthenticationDTO;
import br.com.guilherme.projeto.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO){
        return ResponseEntity.ok(authService.login(authDTO));
    }
}
