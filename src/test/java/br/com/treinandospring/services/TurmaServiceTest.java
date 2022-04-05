package br.com.treinandospring.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.treinandospring.entity.Turma;
import br.com.treinandospring.repository.TurmaRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TurmaServiceTest {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public void listarTurma(){
		
		var jpql = "from Turma";
		
		manager.createQuery(jpql, Turma.class).getResultList().stream()
					.map(a -> "Código: "+a.getCodigo()+" Nome: "+a.getNome())
					.forEach(a -> System.out.println(a));
		
		List<Turma> turma = manager.createQuery(jpql, Turma.class).getResultList();
		for(Turma a : turma) {
			System.out.println("Código: "+a.getCodigo()+" Nome: "+a.getNome());
		}
		
	}
	
	public void listarTurmaCriteria() {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Turma> criteria = builder.createQuery(Turma.class);
		
		Predicate predicate = builder.like(criteria.from(Turma.class).get("nome"), "%A");
		//Predicate predicate2 = builder.lessThan(criteria.from(Turma.class).get("codigo"), 4);
		criteria.where(predicate);
		manager.createQuery(criteria).getResultList().stream().map(a -> a.getNome()).forEach(System.out::println);;
		
		
	}
	
	public void listarTurmaSemAlunos() {
		
		var jpql = "select a from Turma a where not exists (select b from Aluno b where b.turma = a) ";
		
		manager.createQuery(jpql, Turma.class).getResultList().stream()
					.map(a -> "Código: "+a.getCodigo()+" Nome: "+a.getNome())
					.forEach(a -> System.out.println(a));
	}
	
	
	public void listarTurmaComMaisDe2Alunos() {
		
		var jpql = "select a from Turma a where (select count(b) from Aluno b where b.turma = a) = 1 ";
		
		manager.createQuery(jpql, Turma.class).getResultList().stream()
					.map(a -> "Código: "+a.getCodigo()+" Nome: "+a.getNome())
					.forEach(a -> System.out.println(a));
	}
		
	public void listaTurmaPorId() {
		
		turmaRepository.setObject(2).stream().map(a->a.getNome()).forEach(a->System.out.println(a));
		System.out.println("========");
		turmaRepository.setObject2(1).stream().map(a->a.getNome()).forEach(a->System.out.println(a));
		System.out.println("========");
		turmaRepository.setObject3(3).stream().map(a->a.getNome()).forEach(a->System.out.println(a));
	}
	
	public void listarTurmaEntre1a7() {
		
		var jpql = "from Turma a where a between 1 and 2";
		
		manager.createQuery(jpql, Turma.class).getResultList().stream()
				.map(a -> a.getNome()).forEach(a -> System.out.println(a));
		
	}
	

	public void insereTurma() {
		
		for (int i = 0; i < 1000; i++) {
			Turma t = new Turma();
			t.setNome("Turma "+i);
			turmaRepository.save(t);
			System.out.println("OK");
		}
		
	}
	


}
