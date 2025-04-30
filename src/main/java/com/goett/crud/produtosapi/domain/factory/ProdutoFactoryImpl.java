package com.goett.crud.produtosapi.domain.factory;

import org.springframework.stereotype.Component;

import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.domain.model.Produto;

@Component
public class ProdutoFactoryImpl implements ProdutoFactory {

    @Override
    public Produto criarProduto(ProdutoDTO dto) {
        // Aqui você pode validar campos, lançar exceções, etc.
        return new Produto(
            dto.getId(),
            dto.getNome(),
            dto.getDescricao(),
            dto.getPreco(),
            dto.getQuantidade()
        );
    }
}
