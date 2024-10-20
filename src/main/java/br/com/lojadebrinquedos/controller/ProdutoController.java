package br.com.lojadebrinquedos.controller;

import br.com.lojadebrinquedos.model.Produto;
import br.com.lojadebrinquedos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }
}