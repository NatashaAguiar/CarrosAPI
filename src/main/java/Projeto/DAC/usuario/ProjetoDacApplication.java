package Projeto.DAC.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "Projeto.DAC.model")
public class ProjetoDacApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDacApplication.class, args);
	}
}
