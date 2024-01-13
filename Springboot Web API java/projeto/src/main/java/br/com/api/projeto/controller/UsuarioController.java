package br.com.api.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projeto.DAO.InterfaceUsuario;
import br.com.api.projeto.entidade.Usuario;

@RestController // classe de controle, vai ficar todos os endpoints dentro da classe usuarioController
public class UsuarioController {
    
    @Autowired // injeção automática das dependências dos métodos
    private InterfaceUsuario dao;

    @GetMapping("/usuarios")
    public List<Usuario>ListarUsuarios() {
        return (List<Usuario>) dao.findAll();
    }
}
