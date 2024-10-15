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
import Projeto.DAC.model.Carro;
import Projeto.DAC.service.CarroService;

@RestController
@RequestMapping("/api/usuario")
public class CarroController {
	
	private CarroService carroService;
	
	@Autowired
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}
	
	@GetMapping
	public List<Carro> listar(){
		return carroService.listarTodos();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro salvar( @RequestBody @Valid Carro carro ){
        return carroService.salvar(carro);
	}

	@GetMapping("{id}")
	public Carro listarPorId(@PathVariable Integer id) {
		return carroService.listarPorId(id);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		carroService.excluir(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable Integer id, @RequestBody @Valid Carro carroAtualizado) {
		carroService.editar(id, carroAtualizado);
	}
	
}