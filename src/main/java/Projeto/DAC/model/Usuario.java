package Projeto.DAC.model;

import java.util.Date;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuario_id;
	
	@Column(nullable = false, length = 100)
    @NotEmpty
    @NotNull
    private String nome;
	
	@Column(nullable = false, unique = true, length = 11)
    @NotEmpty
    @NotNull
    @CPF
    private String cpf;
	
	@Column(nullable = false)
    @NotEmpty
    @NotNull
    private Date data_nascimento;
	
	@Column(nullable = false, length = 255)
    @NotEmpty
    @NotNull
    private String endereco;
	
	@Column(nullable = false, length = 15)
    @NotEmpty
    @NotNull
    private String telefone;
	
	@Column(nullable = false, unique = true, length = 200)
    @NotNull
    @NotEmpty
    @Email
    private String email;
	
	@Column(nullable = false, unique = true, length = 25)
    @NotNull
    @NotEmpty
    private String senha;

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}