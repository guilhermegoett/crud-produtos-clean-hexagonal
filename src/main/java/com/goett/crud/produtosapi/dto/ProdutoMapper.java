package com.goett.crud.produtosapi.dto;

import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(ProdutoEntity produtoEntity) {
        if (produtoEntity == null) return null;

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produtoEntity.getId());
        dto.setNome(produtoEntity.getNome());
        dto.setDescricao(produtoEntity.getDescricao());
        dto.setPreco(produtoEntity.getPreco());
        dto.setQuantidade(produtoEntity.getQuantidade());
        return dto;
    }

    public static Produto toDomain(ProdutoDTO dto) {
        if (dto == null) return null;
    
        return new Produto(
            dto.getId(),
            dto.getNome(),
            dto.getDescricao(),
            dto.getPreco(),
            dto.getQuantidade()
        );
    }

    // Converte Produto (domínio) para ProdutoEntity (JPA)
    public static ProdutoEntity toEntity(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(produto.getId());
        entity.setNome(produto.getNome());
        entity.setDescricao(produto.getDescricao());
        entity.setPreco(produto.getPreco());
        entity.setQuantidade(produto.getQuantidade());
        return entity;
    }

    public static ProdutoEntity toEntity(ProdutoDTO dto) {
        if (dto == null) return null;
    
        return new ProdutoEntity(
            dto.getId(),
            dto.getNome(),
            dto.getDescricao(),
            dto.getPreco(),
            dto.getQuantidade()
        );
    }
}
