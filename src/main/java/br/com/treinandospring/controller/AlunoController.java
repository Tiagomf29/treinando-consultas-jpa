package br.com.treinandospring.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinandospring.entity.Aluno;
import br.com.treinandospring.services.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/alunos")
	public List<Aluno> listarTodosAlunos(){
		return alunoService.listaTodosAlunos();
	}
	
	@GetMapping("/alunos/comturma")
	public List<Aluno> listarTodosAlunosComTurma(){
		return alunoService.listaTodosAlunosComTurma();
	}
	
	@GetMapping("/alunos/comturmaCor")
	public List<Aluno> listarTodosAlunosComTurmaEComCOr(){
		return alunoService.listaTodosAlunosComTurmaEComCor();
	}
	
	@GetMapping("/alunos/comturmaCorContendoLetra/{letra}")
	public List<Aluno> listarTodosAlunosComTurmaEComCOrContendoLetraA(@PathVariable String letra){
		return alunoService.listaTodosAlunosComTurmaEComCorContendoLetraA(letra);
	}
	
	@GetMapping("/alunos/qtde")
	public BigInteger mostraQuantidadeAlunos() {
		
		return alunoService.mostraContagemAlunos();
	}
	
	@GetMapping("/alunos/custom")
	public List<Object[]> listaAlunoCustom(){
		return alunoService.listaAlunoCustom();
	}
	
	@GetMapping("/alunos/agrupado")
	public List<Object[]> listaAlunoCustomAgrupado(){
		return alunoService.listaAlunoCustomAgrupado();
	}
	
}
