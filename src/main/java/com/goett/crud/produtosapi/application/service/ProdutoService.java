package com.goett.crud.produtosapi.application.service;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.domain.factory.ProdutoFactory;
import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.dto.ProdutoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoFactory produtoFactory;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoFactory produtoFactory, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoFactory = produtoFactory;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoDTO criarProduto(ProdutoDTO dto) {
        // Conversão DTO -> Domínio com validação de regra
        Produto produtoDomain = produtoFactory.criarProduto(dto);

        // Salvar no repositório e obter o domínio salvo
        Produto salvo = produtoRepository.salvar(produtoDomain);

        // Retornar o DTO correspondente ao produto salvo
        return produtoMapper.toDTO(salvo);
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto) {
        // Converter o DTO para o domínio
        Produto produtoAtualizado = new Produto(id, dto.getNome(), dto.getDescricao(), dto.getPreco(), dto.getQuantidade());

        // Atualizar no repositório e obter o produto atualizado
        Produto atualizado = produtoRepository.atualizar(produtoAtualizado);

        // Retornar o DTO do produto atualizado
        return produtoMapper.toDTO(atualizado);
    }

    public void deletarProduto(Long id) {
        // Deletar o produto pelo ID
        produtoRepository.deletar(id);
    }

    public List<ProdutoDTO> listarTodos() {
        // Buscar todos os produtos do repositório e convertê-los para DTO
        return produtoRepository.buscarTodos()
                .stream()
                .map(produtoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> buscarPorId(Long id) {
        // Buscar produto por ID e converter para DTO, se presente
        return produtoRepository.buscarPorId(id)
                .map(produtoMapper::toDTO);
    }
}
