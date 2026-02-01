package com.erick.controlefinanceiro.repository;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoFinanceiroRepository extends JpaRepository<LancamentoFinanceiro, Long> {
}
