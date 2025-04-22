package com.goett.crud.produtosapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Produto {

    private final Long id;
    private final String nome;
    private final String descricao;
    private final Double preco;
    private final Integer quantidade;

    public Produto(Long id, String nome, String descricao, Double preco, Integer quantidade) {
        if (preco != null && preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

}
