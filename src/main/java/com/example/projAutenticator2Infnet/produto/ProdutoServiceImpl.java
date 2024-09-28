package com.example.projAutenticator2Infnet.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        return produto;
    }

    @Override
    public Produto create(Produto produto) {
        if(produto.getId() != null){
            throw new RuntimeException("O produto já existe!");
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        if(produto.getId() != null){
            throw new RuntimeException("Produto Inexistente!");
        }
        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
