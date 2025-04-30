package com.goett.crud.produtosapi.application.port.out;

import com.goett.crud.produtosapi.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    Produto salvar(Produto produto);
    Produto atualizar(Produto produto);
    void deletar(Long id);
    Optional<Produto> buscarPorId(Long id);
    List<Produto> buscarTodos();
}
