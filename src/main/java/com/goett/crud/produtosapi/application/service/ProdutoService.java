package com.goett.crud.produtosapi.application.service;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.dto.ProdutoMapper;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO criarProduto(ProdutoDTO dto) {
        // Conversão DTO -> Domínio com validação de regra
        Produto produtoDomain = ProdutoMapper.toDomain(dto);

        // Conversão Domínio -> Entidade para persistência
        ProdutoEntity entity = ProdutoMapper.toEntity(produtoDomain);

        ProdutoEntity salvo = produtoRepository.salvar(entity);

        // Retornar DTO
        return ProdutoMapper.toDTO(salvo);
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto) {
        Produto produtoDomain = ProdutoMapper.toDomain(dto);
        ProdutoEntity entity = ProdutoMapper.toEntity(produtoDomain);
        entity.setId(id); // Preserva ID

        ProdutoEntity atualizado = produtoRepository.atualizar(entity);

        return ProdutoMapper.toDTO(atualizado);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deletar(id);
    }

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.buscarTodos()
                .stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> buscarPorId(Long id) {
        return produtoRepository.buscarPorId(id)
                .map(ProdutoMapper::toDTO);
    }
}
