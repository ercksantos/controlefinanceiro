package com.erick.controlefinanceiro.service;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import com.erick.controlefinanceiro.repository.LancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoFinanceiroService {

    @Autowired
    private LancamentoFinanceiroRepository repository;

    public LancamentoFinanceiro salvar(LancamentoFinanceiro lancamento) {
        return repository.save(lancamento);
    }

    public List<LancamentoFinanceiro> listarTodos() {
        return repository.findAll();
    }
}
