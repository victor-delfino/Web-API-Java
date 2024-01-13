package br.com.api.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projeto.DAO.InterfaceUsuario;
import br.com.api.projeto.entidade.Usuario;

@RestController // classe de controle, vai ficar todos os endpoints dentro da classe usuarioController
@CrossOrigin("*") // liberar todas as entradas da máquina
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired // injeção automática das dependências dos métodos do crud repository
    private InterfaceUsuario dao;

    @GetMapping
    public ResponseEntity <List<Usuario>> ListarUsuarios() {
        List<Usuario> lista = (List<Usuario>) dao.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity <Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = dao.save(usuario);
        return ResponseEntity.status(201).body(usuarioNovo);
    }

    @PutMapping
    public ResponseEntity <Usuario>  alterarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = dao.save(usuario);
        return ResponseEntity.status(201).body(usuarioNovo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deletarUsuario(@PathVariable Integer id) {
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
