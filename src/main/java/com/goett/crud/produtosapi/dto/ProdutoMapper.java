package com.goett.crud.produtosapi.dto;

import com.goett.crud.produtosapi.domain.factory.ProdutoFactory;
import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    private final ProdutoFactory produtoFactory;

    public ProdutoMapper(ProdutoFactory produtoFactory) {
        this.produtoFactory = produtoFactory;
    }

    // Converte ProdutoEntity para ProdutoDTO (camada externa)
    public ProdutoDTO toDTO(ProdutoEntity produtoEntity) {
        if (produtoEntity == null) return null;

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produtoEntity.getId());
        dto.setNome(produtoEntity.getNome());
        dto.setDescricao(produtoEntity.getDescricao());
        dto.setPreco(produtoEntity.getPreco());
        dto.setQuantidade(produtoEntity.getQuantidade());
        return dto;
    }

    // Converte Produto (domínio) para ProdutoDTO
    public ProdutoDTO toDTO(Produto produto) {
        if (produto == null) return null;

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade());
        return dto;
    }

    // Converte ProdutoDTO para Produto (domínio)
    public Produto toDomain(ProdutoDTO dto) {
        if (dto == null) return null;
        return produtoFactory.criarProduto(dto);
    }

    // Converte ProdutoDTO para Produto (domínio)
    public Produto toDomain(ProdutoEntity produtoEntity) {
        if (produtoEntity == null) return null;
        ProdutoDTO dto = new ProdutoDTO();
        dto = this.toDTO(produtoEntity);
        return produtoFactory.criarProduto(dto);
    }

    // Converte Produto (domínio) para ProdutoEntity (persistência JPA)
    public ProdutoEntity toEntity(Produto produto) {
        if (produto == null) return null;
        
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(produto.getId());
        entity.setNome(produto.getNome());
        entity.setDescricao(produto.getDescricao());
        entity.setPreco(produto.getPreco());
        entity.setQuantidade(produto.getQuantidade());
        return entity;
    }

    // Converte ProdutoDTO para ProdutoEntity
    public ProdutoEntity toEntity(ProdutoDTO dto) {
        if (dto == null) return null;
        
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        return entity;
    }
}
