package com.example.projAutenticator2Infnet.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Produto> listAll(){
       return produtoService.findAll();
    }

    @PreAuthorize("hasRole('PRODUCT_CREATE')")
    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Produto update(@RequestBody Produto produto){
        return produtoService.update(produto);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        produtoService.delete(id);
    }
}
