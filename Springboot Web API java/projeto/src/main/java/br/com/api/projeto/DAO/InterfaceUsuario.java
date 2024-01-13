package br.com.api.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.api.projeto.entidade.Usuario;

public interface InterfaceUsuario extends CrudRepository<Usuario, Integer>{
    
}
