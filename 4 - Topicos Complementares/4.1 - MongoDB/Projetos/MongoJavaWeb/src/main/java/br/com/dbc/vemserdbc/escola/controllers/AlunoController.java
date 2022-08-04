package br.com.dbc.vemserdbc.escola.controllers;

import java.util.List;

import br.com.dbc.vemserdbc.escola.repositorys.AlunoRepository;
import br.com.dbc.vemserdbc.escola.service.GeolocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dbc.vemserdbc.escola.models.Aluno;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private GeolocalizacaoService geolocalizacaoService;
	
	@GetMapping("/aluno/cadastrar")
	public String cadastrar(Model model){
		model.addAttribute("aluno", new Aluno()); 
		return "aluno/cadastrar";
	}
	
	@PostMapping("/aluno/salvar")
	public String salvar(@ModelAttribute Aluno aluno){
		System.out.println("Aluno para salvar: " + aluno);
		try {
			List<Double> latElong = geolocalizacaoService.obterLatELongPor(aluno.getContato());
			aluno.getContato().setCoordinates(latElong);
			repository.salvar(aluno);
		} catch (Exception e) {
			System.out.println("Endereco nao localizado");
			e.printStackTrace();
		} 
		
		return "redirect:/";
	}
	
	@GetMapping("/aluno/listar")
	public String listar(Model model){
		List<Aluno> alunos = repository.obterTodosAlunos();
		model.addAttribute("alunos", alunos);
		return "aluno/listar";
	}
	
	@GetMapping("/aluno/visualizar/{id}")
	public String visualizar(@PathVariable String id, Model model){
		
		Aluno aluno = repository.obterAlunoPor(id);
		
		model.addAttribute("aluno", aluno);
		
		return "aluno/visualizar";
	}
	
	@GetMapping("/aluno/pesquisarnome")
	public String pesquisarNome(){
		return "aluno/pesquisarnome";
	}
	
	@GetMapping("/aluno/pesquisar")
	public String pesquisar(@RequestParam("nome") String nome, Model model){
		List<Aluno> alunos = repository.pesquisarPor(nome);
		
		model.addAttribute("alunos", alunos);
		
		
		return "aluno/pesquisarnome"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
