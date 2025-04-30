package com.goett.crud.produtosapi.application.service;

import com.goett.crud.produtosapi.application.port.out.ProdutoRepository;
import com.goett.crud.produtosapi.domain.factory.ProdutoFactory;
import com.goett.crud.produtosapi.domain.model.Produto;
import com.goett.crud.produtosapi.dto.ProdutoDTO;
import com.goett.crud.produtosapi.dto.ProdutoMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoMapper produtoMapper;

    @Mock
    private ProdutoFactory produtoFactory;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        produtoService = new ProdutoService(produtoRepository,produtoFactory, produtoMapper);
    }

    @Test
    void testCriarProduto() {
        ProdutoDTO dto = new ProdutoDTO(null, "Produto A", "Descricao", 100.0, 10);
        Produto produto = new Produto(null, "Produto A", "Descricao", 100.0, 10);
        Produto produtoSalvo = new Produto(1L, "Produto A", "Descricao", 100.0, 10);
        ProdutoDTO dtoSalvo = new ProdutoDTO(1L, "Produto A", "Descricao", 100.0, 10);

        when(produtoFactory.criarProduto(dto)).thenReturn(produto);
        when(produtoRepository.salvar(produto)).thenReturn(produtoSalvo);
        when(produtoMapper.toDTO(produtoSalvo)).thenReturn(dtoSalvo);

        ProdutoDTO result = produtoService.criarProduto(dto);

        assertNotNull(result.getId());
        assertEquals("Produto A", result.getNome());
        verify(produtoRepository).salvar(produto);
    }

    @Test
    void testAtualizarProduto() {
        ProdutoDTO dto = new ProdutoDTO(null, "Atualizado", "Nova Desc", 200.0, 20);
        Produto produto = new Produto(1L, "Atualizado", "Nova Desc", 200.0, 20);
        Produto atualizado = new Produto(1L, "Atualizado", "Nova Desc", 200.0, 20);
        ProdutoDTO dtoAtualizado = new ProdutoDTO(1L, "Atualizado", "Nova Desc", 200.0, 20);

        when(produtoFactory.criarProduto(dto)).thenReturn(produto);
        when(produtoRepository.atualizar(produto)).thenReturn(atualizado);
        when(produtoMapper.toDTO(atualizado)).thenReturn(dtoAtualizado);

        ProdutoDTO result = produtoService.atualizarProduto(1L, dto);

        assertEquals("Atualizado", result.getNome());
        verify(produtoRepository).atualizar(produto);
    }

    @Test
    void testDeletarProduto() {
        doNothing().when(produtoRepository).deletar(1L);
        produtoService.deletarProduto(1L);
        verify(produtoRepository).deletar(1L);
    }

    @Test
    void testListarTodos() {
        List<Produto> lista = Arrays.asList(
            new Produto(1L, "A", "Desc A", 10.0, 5),
            new Produto(2L, "B", "Desc B", 20.0, 10)
        );

        List<ProdutoDTO> dtos = Arrays.asList(
            new ProdutoDTO(1L, "A", "Desc A", 10.0, 5),
            new ProdutoDTO(2L, "B", "Desc B", 20.0, 10)
        );

        when(produtoRepository.buscarTodos()).thenReturn(lista);
        when(produtoMapper.toDTO(lista.get(0))).thenReturn(dtos.get(0));
        when(produtoMapper.toDTO(lista.get(1))).thenReturn(dtos.get(1));

        List<ProdutoDTO> result = produtoService.listarTodos();

        assertEquals(2, result.size());
        verify(produtoRepository).buscarTodos();
    }

    @Test
    void testBuscarPorId() {
        Produto produto = new Produto(1L, "Produto X", "Descricao X", 150.0, 8);
        ProdutoDTO dto = new ProdutoDTO(1L, "Produto X", "Descricao X", 150.0, 8);

        when(produtoRepository.buscarPorId(1L)).thenReturn(Optional.of(produto));
        when(produtoMapper.toDTO(produto)).thenReturn(dto);

        Optional<ProdutoDTO> result = produtoService.buscarPorId(1L);

        assertTrue(result.isPresent());
        assertEquals("Produto X", result.get().getNome());
    }
}
