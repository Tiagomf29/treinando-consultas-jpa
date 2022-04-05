package br.com.treinandospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	
	@Column(length = 40, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_turma", nullable = true, foreignKey = @ForeignKey(name = "fk_id_turma"))
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name = "id_cor",nullable = true, foreignKey = @ForeignKey(name="fk_id_cor"))
	private Cor cor;

}
