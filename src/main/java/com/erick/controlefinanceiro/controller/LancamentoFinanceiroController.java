package com.erick.controlefinanceiro.controller;

import com.erick.controlefinanceiro.dto.LancamentoFinanceiroRequestDTO;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroResponseDTO;
import com.erick.controlefinanceiro.service.LancamentoFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoFinanceiroController {

    @Autowired
    private LancamentoFinanceiroService service;

    @PostMapping
    public ResponseEntity<LancamentoFinanceiroResponseDTO> salvar(@RequestBody LancamentoFinanceiroRequestDTO requestDTO) {
        LancamentoFinanceiroResponseDTO responseDTO = service.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> listarTodos() {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.listarTodos();
        return ResponseEntity.ok(lancamentos);
    }
}
