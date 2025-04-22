package com.goett.crud.produtosapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());

        // Verifica se o erro específico de preço negativo
        if (ex.getMessage().contains("preço não pode ser negativo")) {
            erro.put("error", "Preço inválido");
            erro.put("message", "O campo 'preço' deve ser um valor positivo.");
        } else {
            erro.put("error", "Dados inválidos");
            erro.put("message", ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
