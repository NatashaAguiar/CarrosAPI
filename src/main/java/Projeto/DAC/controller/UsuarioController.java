package Projeto.DAC.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import Projeto.DAC.model.Usuario;
import Projeto.DAC.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioService.listarTodos();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar( @RequestBody @Valid Usuario usuario ){
        return usuarioService.salvar(usuario);
    }
	
	@GetMapping("{id}")
	public Usuario listarPorId(@PathVariable Integer id) {
		return usuarioService.listarPorId(id);
	}
	
	@GetMapping("{id}/telefone")
	public String listarPorTelefone(@PathVariable Integer id) {
		return usuarioService.listarPorTelefone(id);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		usuarioService.excluir(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable Integer id, @RequestBody @Valid Usuario usuarioAtualizado) {
		usuarioService.editar(id, usuarioAtualizado);
	}
	
}
