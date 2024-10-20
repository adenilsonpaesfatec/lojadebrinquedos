package br.com.lojadebrinquedos.controller;

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
@RequestMapping("/api/produtos")
public class ProdutoController {
	// Injeção de dependência
	@Autowired
	private ProdutoRepository produtoRepository;
	
	// Post
	@PostMapping
	public Produto insert(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// Get
	// Pesquisar todos os produtos
	@GetMapping
	public List<Produto> listarTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	// Pesquisar por id
	@GetMapping("/{id}")
	public Produto pesquisarPorId(@PathVariable Integer id) {
		Produto produto = produtoRepository.findById(id).get();
		return produto;
	}
	
	// Pesquisar por descricao
	@GetMapping("/descricao/{descricao}")
	public Produto pesquisarPorDescricao(@PathVariable String descricao) {
		Produto produto = produtoRepository.findByDescricao(descricao);
		return produto;
	}
	
	// Pesquisar por categoria
	@GetMapping("/categoria/{categoria}")
	public List<Produto> pesquisarPorCategoria(@PathVariable String categoria) {
		List<Produto> produtos = produtoRepository.findByCategoria(categoria);
		return produtos;
	}
	
	// Put
	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
		pesquisarPorId(id);
		produto.setDescricao(produto.getDescricao());
		produto.setCategoria(produto.getCategoria());
		produto.setMarca(produto.getMarca());
		produto.setImagem(produto.getImagem());
		produto.setValor(produto.getValor());
		produto.setDetalhes(produto.getDetalhes());
		produtoRepository.save(produto);
		return produto;
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public String apagarProduto(@PathVariable("id") Integer id) {
		produtoRepository.deleteById(id);
		return "Produto apagado com sucesso!";
	}
}
