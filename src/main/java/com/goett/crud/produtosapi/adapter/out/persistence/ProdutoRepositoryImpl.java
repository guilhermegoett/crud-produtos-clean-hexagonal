package com.goett.crud.produtosapi.adapter.out.persistence;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;
import com.goett.crud.produtosapi.dto.ProdutoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository produtoJpaRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoRepositoryImpl(ProdutoJpaRepository produtoJpaRepository, ProdutoMapper produtoMapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = produtoMapper.toEntity(produto);
        ProdutoEntity salvo = produtoJpaRepository.save(entity);
        return produtoMapper.toDomain(salvo);
    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoEntity entity = produtoMapper.toEntity(produto);
        ProdutoEntity atualizado = produtoJpaRepository.save(entity);
        return produtoMapper.toDomain(atualizado);
    }

    @Override
    public void deletar(Long id) {
        produtoJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoJpaRepository.findById(id)
                .map(produtoMapper::toDomain);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoJpaRepository.findAll()
                .stream()
                .map(produtoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
