package com.desafio.gerenciamento.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer quantidade;

}
