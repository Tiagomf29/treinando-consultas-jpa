package br.com.treinandospring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinandospring.entity.Turma;
import br.com.treinandospring.repository.TurmaRepository;
import br.com.treinandospring.services.TurmaService;

@RestController
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/turmas")
	public Page<Turma> listarTodos(@PageableDefault(size = 5) Pageable pageable){
		
		return turmaService.listarTodos(pageable);
		
	}
	
	@GetMapping("/turmas/all")
	public List<Turma> listarTodosAll(){
		
		return turmaRepository.findAll();
		
	}
}
