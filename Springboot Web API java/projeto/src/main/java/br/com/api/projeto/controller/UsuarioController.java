package br.com.api.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // classe de controle, vai ficar todos os endpoints dentro da classe usuarioController
public class UsuarioController {
    
    @GetMapping("/usuarios")
    public String texto() {
        return "Acessando a api";
    }
}
