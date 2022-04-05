package br.com.treinandospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.treinandospring.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{
	
	@Query(value = "from Turma a where a.id = :id")
	public List<Turma> setObject(int id);

	@Query(value = "from Turma a where a.id = ?1")
	public List<Turma> setObject2(int id);
	
	@Query(value = "from Turma a where a.id = :codigo")
	public List<Turma> setObject3(@Param("codigo")int id);
}
