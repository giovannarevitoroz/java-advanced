package br.com.fiap.cp01.checkpoint01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class GlobalExceptionHandler {
    public ResponseEntity<Object> handlerLivroNaoEncontradoException (LivroNaoEncontradoException ex) {
        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("mensagem", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
