package br.com.api.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.projeto.DAO.InterfaceUsuario;
import br.com.api.projeto.entidade.Usuario;

@Service
public class UsuarioService {

    private InterfaceUsuario dao;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(InterfaceUsuario dao) {
        this.dao = dao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = dao.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    public Usuario alterarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }
    public Boolean deletarUsuario(Integer id) {
        dao.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = dao.getById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
