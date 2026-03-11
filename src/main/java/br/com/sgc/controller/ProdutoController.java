package br.com.sgc.controller;

import br.com.sgc.domain.model.Produto;
import br.com.sgc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Rota exigida pelo trabalho para listar produtos (GET /produtos)
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Rota para cadastrar um novo produto no banco (POST /produtos)
    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}