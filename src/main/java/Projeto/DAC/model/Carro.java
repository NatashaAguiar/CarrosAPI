package Projeto.DAC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carro_id;
	
	@Column(nullable = false, length = 50)
    @NotEmpty
    @NotNull
    private String modelo;
	
	@Column(nullable = false, length = 50)
    @NotEmpty
    @NotNull
    private String fabricante;

	@Column(nullable = false)
    @NotEmpty
    @NotNull
    private int ano;
	
	@Column(nullable = false)
    @NotEmpty
    @NotNull
    private double preco;

	public Integer getCarro_id() {
		return carro_id;
	}

	public void setCarro_id(Integer carro_id) {
		this.carro_id = carro_id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
