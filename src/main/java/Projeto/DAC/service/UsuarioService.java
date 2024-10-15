package Projeto.DAC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projeto.DAC.model.Usuario;
import Projeto.DAC.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
	
	public Usuario listarPorId(Integer id) {
		return usuarioRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") );
	}
	
	public void excluir(Integer id) {
		usuarioRepository.findById(id).map(usuario -> {
	        	usuarioRepository.delete(usuario);
	            return Void.TYPE;
	        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	}
	
	public void editar(Integer id, Usuario usuarioAtualizado) {
		usuarioRepository.findById(id)
        .map( usuario -> {
        	usuario.setNome(usuarioAtualizado.getNome());
        	usuario.setCpf(usuarioAtualizado.getCpf());
        	usuario.setData_nascimento(usuarioAtualizado.getData_nascimento());
        	usuario.setEndereco(usuarioAtualizado.getEndereco());
        	usuario.setTelefone(usuarioAtualizado.getTelefone());
        	usuario.setEmail(usuarioAtualizado.getEmail());
        	usuario.setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuario);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") );
	}

}
