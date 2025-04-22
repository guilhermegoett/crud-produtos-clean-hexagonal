package com.goett.crud.produtosapi.application.service;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarProduto() {
        ProdutoDTO dto = new ProdutoDTO(null, "Produto A", "Descricao", 100.0, 10);
        ProdutoEntity salvo = new ProdutoEntity(1L, "Produto A", "Descricao", 100.0, 10);

        when(produtoRepository.salvar(any())).thenReturn(salvo);

        ProdutoDTO result = produtoService.criarProduto(dto);

        assertNotNull(result.getId());
        assertEquals("Produto A", result.getNome());
        verify(produtoRepository).salvar(any());
    }

    @Test
    void testAtualizarProduto() {
        ProdutoDTO dto = new ProdutoDTO(null, "Atualizado", "Nova Desc", 200.0, 20);
        ProdutoEntity atualizado = new ProdutoEntity(1L, "Atualizado", "Nova Desc", 200.0, 20);

        when(produtoRepository.atualizar(any())).thenReturn(atualizado);

        ProdutoDTO result = produtoService.atualizarProduto(1L, dto);

        assertEquals("Atualizado", result.getNome());
        verify(produtoRepository).atualizar(any());
    }

    @Test
    void testDeletarProduto() {
        doNothing().when(produtoRepository).deletar(1L);

        produtoService.deletarProduto(1L);

        verify(produtoRepository).deletar(1L);
    }

    @Test
    void testListarTodos() {
        List<ProdutoEntity> lista = Arrays.asList(
            new ProdutoEntity(1L, "A", "Desc A", 10.0, 5),
            new ProdutoEntity(2L, "B", "Desc B", 20.0, 10)
        );

        when(produtoRepository.buscarTodos()).thenReturn(lista);

        List<ProdutoDTO> result = produtoService.listarTodos();

        assertEquals(2, result.size());
    }

    @Test
    void testBuscarPorId() {
        ProdutoEntity produto = new ProdutoEntity(1L, "Produto X", "Descricao X", 150.0, 8);

        when(produtoRepository.buscarPorId(1L)).thenReturn(Optional.of(produto));

        Optional<ProdutoDTO> result = produtoService.buscarPorId(1L);

        assertTrue(result.isPresent());
        assertEquals("Produto X", result.get().getNome());
    }
}
