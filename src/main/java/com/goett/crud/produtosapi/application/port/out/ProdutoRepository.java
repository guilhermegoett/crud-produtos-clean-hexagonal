package com.goett.crud.produtosapi.application.port.out;

import java.util.List;
import java.util.Optional;

import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;

public interface ProdutoRepository {

    ProdutoEntity salvar(ProdutoEntity produto);
    ProdutoEntity atualizar(ProdutoEntity produto);
    void deletar(Long id);
    Optional<ProdutoEntity> buscarPorId(Long id);
    List<ProdutoEntity> buscarTodos();
}
