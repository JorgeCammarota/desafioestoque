package com.desafio.gerenciamento.controller;

import com.desafio.gerenciamento.model.ProdutoModel;
import com.desafio.gerenciamento.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/estoque")


public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @GetMapping
    public List<ProdutoModel> listar(){
        return produtoService.listar();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id){
        Optional<ProdutoModel> produtoModel = produtoService.buscarPorId(id);
        if (produtoModel.isPresent()){
            return ResponseEntity.ok(produtoModel.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);
        if (produto.isPresent()){    produtoService.deletar(id);}
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado!");
        }
    }
    @PostMapping
    public ResponseEntity<ProdutoModel> cadastrar(@RequestBody ProdutoModel produtoModel){
        ProdutoModel novoProduto = produtoService.cadastrar(produtoModel);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
    @PutMapping(path = "/{id}")
    public ProdutoModel alterar(@PathVariable Long id,
                                @RequestBody ProdutoModel produtoModel){

        return produtoService.alterar(id, produtoModel);
    }

    }
