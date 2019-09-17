package com.fatec.scel.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

@Entity(name = "Aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@NaturalId
	@Column(nullable = false, length = 100)
	@NotEmpty(message="O RA deve ser preenchido")
	private String ra;
	
	@Column(nullable = false, length = 100)
	@NotEmpty(message="O titulo deve ser preenchido")
	private String nome;
	
	@Column(nullable = false)
	@NotNull(message="Aluno invalido")
	@Size(min = 12, max = 50, message="O email deve ter entre 12 e 50 caracteres")
	private String email;
	
	
	public Aluno() {
		
	}
	public Aluno(String ra, String nome, String email) {
		this.ra = ra;
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRA() {
		return ra;
	}
	public void setRA(String ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
