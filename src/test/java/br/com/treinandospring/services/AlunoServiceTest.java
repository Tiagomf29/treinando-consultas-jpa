package br.com.treinandospring.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.treinandospring.entity.Aluno;
import br.com.treinandospring.entity.Cor;
import br.com.treinandospring.entity.Turma;
import br.com.treinandospring.repository.AlunoRespositorioCustom;
import br.com.treinandospring.services.AlunoService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlunoServiceTest {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	AlunoRespositorioCustom  alunoRespositorioCustom;
	
	@Test
	public void customAluno() {
		
      List<Object[]> lista =  alunoService.listaAlunoCustom();
      lista.stream().forEach(arr -> System.out.println(
    		  String.format("Aluno: %s, Turma: %s, Cor: %s", arr[0], arr[1], arr[2])));
	}
	

	@Test
	public void customAlunoAgrupado() {
		
      List<Object[]> lista =  alunoService.listaAlunoCustomAgrupado();
      lista.stream().forEach(arr -> System.out.println(
    		  String.format("Aluno: %s, Quantidade: %s", arr[0], arr[1])));
	}
	
	@Test
	public void alunoCustomJpql() {
		
		
		List<Aluno> aluno =  alunoRespositorioCustom.listaJPQLCustom();
		
		for(Aluno a : aluno) {
			Optional<Turma> turma = Optional.ofNullable(a.getTurma());
			Optional<Cor> cor = Optional.ofNullable(a.getCor());
			
			System.out.print("Nome: "+ a.getNome());
			if(turma.isPresent()) {
				System.out.print(", Turma: "+a.getTurma().getNome());
			}
			if(cor.isPresent()) {
				System.out.print(", Cor: "+ a.getCor().getNome());
			}
			System.out.println("");
		}
	}
	
	@Test
	public void alunoCustomJpqlLambda() {
		
		List<Aluno> aluno =  alunoRespositorioCustom.listaJPQLCustom();
		
		aluno.stream().map(a -> "Nome:"+a.getNome()+
						        (!Optional.ofNullable(a.getTurma()).isPresent()?"":",Turma: "+a.getTurma().getNome())+
						        (!Optional.ofNullable(a.getCor()).isPresent()?"":"Cor: "+a.getCor().getNome()))
					  .forEach(a -> System.out.println(a));
	}

}
