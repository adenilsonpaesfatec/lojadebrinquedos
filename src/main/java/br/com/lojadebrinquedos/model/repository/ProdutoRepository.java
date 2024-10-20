package br.com.lojadebrinquedos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lojadebrinquedos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	// Pesquisar por descricao
	Produto findByDescricao(String descricao);
	
	// Pesquisar por categoria
	List<Produto> findByCategoria(String categoria);
}