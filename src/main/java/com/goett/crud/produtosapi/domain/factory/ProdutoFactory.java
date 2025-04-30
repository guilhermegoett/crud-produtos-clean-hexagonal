package com.goett.crud.produtosapi.domain.factory;

import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.domain.model.Produto;

public interface ProdutoFactory {
    Produto criarProduto(ProdutoDTO dto);
}
