package com.goett.crud.produtosapi.application.controller;

import com.goett.crud.produtosapi.application.service.ProdutoService;
import com.goett.crud.produtosapi.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(summary = "Cria um novo produto", description = "Este endpoint cria um novo produto no sistema com os dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro de validação de dados.")
    })
    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = produtoService.criarProduto(dto);
        return ResponseEntity.status(201).body(produto);
    }

    @Operation(summary = "Atualiza um produto existente", description = "Este endpoint atualiza um produto existente com os dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@Parameter(description = "ID do produto a ser atualizado") @PathVariable Long id,
                                                @RequestBody ProdutoDTO dto) {
        ProdutoDTO produto = produtoService.atualizarProduto(id, dto);
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Deleta um produto", description = "Este endpoint remove um produto do sistema pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@Parameter(description = "ID do produto a ser deletado") @PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca todos os produtos", description = "Este endpoint retorna todos os produtos cadastrados no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso.")
    })
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Busca um produto por ID", description = "Este endpoint retorna um produto específico pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado."),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@Parameter(description = "ID do produto a ser buscado") @PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
