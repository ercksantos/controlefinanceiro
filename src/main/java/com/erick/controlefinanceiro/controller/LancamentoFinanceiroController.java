package com.erick.controlefinanceiro.controller;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import com.erick.controlefinanceiro.repository.LancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoFinanceiroController {

    @Autowired
    private LancamentoFinanceiroRepository repository;

    @PostMapping
    public ResponseEntity<LancamentoFinanceiro> salvar(@RequestBody LancamentoFinanceiro lancamento) {
        LancamentoFinanceiro salvo = repository.save(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoFinanceiro>> listarTodos() {
        List<LancamentoFinanceiro> lancamentos = repository.findAll();
        return ResponseEntity.ok(lancamentos);
    }
}
