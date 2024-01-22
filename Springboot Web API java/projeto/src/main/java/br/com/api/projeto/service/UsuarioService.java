package br.com.api.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.api.projeto.DAO.InterfaceUsuario;
import br.com.api.projeto.entidade.Usuario;

@Service
public class UsuarioService {

    private InterfaceUsuario dao;

    public UsuarioService(InterfaceUsuario dao) {
        this.dao = dao;
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = dao.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    public Usuario alterarUsuario(Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }
    public Boolean deletarUsuario(Integer id) {
        dao.deleteById(id);
        return true;
    }
}
