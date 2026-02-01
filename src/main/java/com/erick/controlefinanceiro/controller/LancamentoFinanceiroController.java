package com.erick.controlefinanceiro.controller;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
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
    public ResponseEntity<LancamentoFinanceiro> salvar(@RequestBody LancamentoFinanceiro lancamento) {
        LancamentoFinanceiro salvo = service.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoFinanceiro>> listarTodos() {
        List<LancamentoFinanceiro> lancamentos = service.listarTodos();
        return ResponseEntity.ok(lancamentos);
    }
}
