package br.com.api.projeto.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.projeto.entidade.Usuario;

public interface InterfaceUsuario extends JpaRepository<Usuario, Integer>{
    
}
