package br.com.treinandospring.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinandospring.entity.Aluno;
import br.com.treinandospring.repository.AlunoRespositorioCustom;

@Service
public class AlunoService {

	@Autowired
	private AlunoRespositorioCustom alunoRespositorioCustom;
	
	public List<Aluno>listaTodosAlunos(){
		
		return alunoRespositorioCustom.listarTodosAlunos();
	}
	
	public List<Aluno>listaTodosAlunosComTurma(){
		
		return alunoRespositorioCustom.listarTodosAlunosComTurma();
	}
	
	public List<Aluno>listaTodosAlunosComTurmaEComCor(){
		
		return alunoRespositorioCustom.listarTodosAlunosComTurmaEComCor();
	}
	
	public List<Aluno>listaTodosAlunosComTurmaEComCorContendoLetraA(String nome){
		
		return alunoRespositorioCustom.listarTodosAlunosComTurmaEComCorContendoALetraA(nome);
	}
	
	public BigInteger mostraContagemAlunos(){
		
		return alunoRespositorioCustom.mostraContagemAlunos();
		
	}
	
	public List<Object[]> listaAlunoCustom(){
		return alunoRespositorioCustom.listaAlunoCustom();
	}
	
	public List<Object[]> listaAlunoCustomAgrupado(){
		return alunoRespositorioCustom.listaAlunoCustomAgrupado();
	}
	
	
	
}
