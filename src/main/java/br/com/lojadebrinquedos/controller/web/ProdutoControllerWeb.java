package br.com.lojadebrinquedos.controller.web;

import br.com.lojadebrinquedos.model.Categoria;
import br.com.lojadebrinquedos.model.Produto;
import br.com.lojadebrinquedos.model.repository.CategoriaRepository;
import br.com.lojadebrinquedos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/produtos")
public class ProdutoControllerWeb {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String novoProdutoForm(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("produto", new Produto());
        return "produtos/form";
    }

    @PostMapping
    public String adicionarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/web/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarProdutoForm(@PathVariable int id, Model model) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            return "redirect:/web/produtos";
        }
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("produto", produto.get());
        return "produtos/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarProduto(@PathVariable int id, @ModelAttribute Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (!produtoExistente.isPresent()) {
            return "redirect:/web/produtos";
        }
        Produto produto = produtoExistente.get();
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setMarca(produtoAtualizado.getMarca());
        produto.setImagem(produtoAtualizado.getImagem());
        produto.setValor(produtoAtualizado.getValor());
        produto.setDetalhes(produtoAtualizado.getDetalhes());
        produtoRepository.save(produto);
        return "redirect:/web/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable int id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
        return "redirect:/web/produtos";
    }
}