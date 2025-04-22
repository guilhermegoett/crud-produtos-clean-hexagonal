package com.goett.crud.produtosapi.adapter.out.persistence;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    public ProdutoEntity salvar(ProdutoEntity produto) {
        return produtoJpaRepository.save(produto);
    }

    @Override
    public ProdutoEntity atualizar(ProdutoEntity produto) {
        return produtoJpaRepository.save(produto); // save faz update se ja existir o ID
    }

    @Override
    public void deletar(Long id) {
        produtoJpaRepository.deleteById(id);
    }

    @Override
    public Optional<ProdutoEntity> buscarPorId(Long id) {
        return produtoJpaRepository.findById(id);
    }

    @Override
    public List<ProdutoEntity> buscarTodos() {
        return produtoJpaRepository.findAll();
    }
}
