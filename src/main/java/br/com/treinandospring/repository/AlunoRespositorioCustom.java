package br.com.treinandospring.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.treinandospring.entity.Aluno;

@Repository
public class AlunoRespositorioCustom{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Aluno> listarTodosAlunos(){
		
		var jpql = "from Aluno a";
		return manager.createQuery(jpql, Aluno.class).getResultList();
		
	}
	
	public List<Aluno> listarTodosAlunosComTurma(){
		
		var jpql = "select a from Aluno a inner join a.turma as trm";
		return manager.createQuery(jpql, Aluno.class).getResultList();
		
	}
	
	public List<Aluno> listarTodosAlunosComTurmaEComCor(){
		
		var jpql = "select a from Aluno a inner join a.turma as trm inner join a.cor as cor";
		return manager.createQuery(jpql, Aluno.class).getResultList();
		
	}
	
	public List<Aluno> listarTodosAlunosComTurmaEComCorContendoALetraA(String nome){
		
		var jpql = "select a from Aluno a inner join a.turma as trm inner join a.cor as cor where cor.nome like :nome";
		return manager.createQuery(jpql, Aluno.class).setParameter("nome", "%"+nome+"%").getResultList();
		
	}
	
	public BigInteger mostraContagemAlunos(){
		
		var sql = "select count(a.*) from Aluno a inner join Turma b on a.id_turma = b.codigo inner join cor c on c.id = a.id_cor";
		return (BigInteger) manager.createNativeQuery(sql).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listaAlunoCustom(){
		
		var sql = "select a.nome as nome, b.nome as turma , c.nome as cor from Aluno a left join Turma b on a.id_turma = b.codigo "
				+ "left join Cor c on a.id_cor = c.id";
	
		return manager.createNativeQuery(sql).getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listaAlunoCustomAgrupado(){
		
		var sql = "select b.nome as turma , count(*) as qtde from Aluno a inner join Turma b on a.id_turma = b.codigo "
				+ "left join Cor c on a.id_cor = c.id group by b.nome";
		
		Query qry = manager.createNativeQuery(sql); 
		
		return qry.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listaJPQLCustom(){
		
		var jpql = "select a from Aluno a join a.turma join a.cor ";
		
		Query qry =  manager.createQuery(jpql,Aluno.class);
		
		return qry.getResultList();
		
	}
	
		
}
