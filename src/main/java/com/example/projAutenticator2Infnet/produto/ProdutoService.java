package com.example.projAutenticator2Infnet.produto;


import java.util.List;

public interface ProdutoService {

    List<Produto> findAll ();
    Produto findById (Long id);
    Produto create(Produto produto);
    Produto update(Produto produto);
    void delete(Long id);
}
