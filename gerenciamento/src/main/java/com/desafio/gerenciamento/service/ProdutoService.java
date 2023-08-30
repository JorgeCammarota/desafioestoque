package com.desafio.gerenciamento.service;

import com.desafio.gerenciamento.model.ProdutoModel;
import com.desafio.gerenciamento.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
    public List<ProdutoModel> listar(){
        return produtoRepository.findAll();
    }
    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
    public ProdutoModel cadastrar(ProdutoModel produtoModel) {

        return produtoRepository.save(produtoModel);

    }

    public ProdutoModel alterar(Long id , ProdutoModel produtoModel){
        ProdutoModel produtos = buscarPorId(id).get();

        if (produtoModel.getNome() != null){
            produtos.setNome(produtoModel.getNome());
        }
        if (produtoModel.getDescricao() != null){
            produtos.setDescricao(produtoModel.getDescricao());
        }
        if (produtoModel.getPreco() != null){
            produtos.setPreco(produtoModel.getPreco());
        }
        if (produtoModel.getQuantidade() != null){
            produtos.setQuantidade(produtoModel.getQuantidade());
        }
        return produtoRepository.save(produtos);

    }
}

