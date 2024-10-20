package br.com.lojadebrinquedos.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojadebrinquedos.model.Produto;
import br.com.lojadebrinquedos.model.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutoControllerWeb {
	// Injeção de dependência
	@Autowired
	private ProdutoRepository produtoRepository;
	
	// Get
	@GetMapping("index")
	public String index() {
		return "index";
	}
}
