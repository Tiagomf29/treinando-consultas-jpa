package br.com.treinandospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.treinandospring.entity.Turma;
import br.com.treinandospring.repository.TurmaRepository;



@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	public Page<Turma> listarTodos(Pageable pageable){
		return turmaRepository.findAll(pageable);
	}
}
