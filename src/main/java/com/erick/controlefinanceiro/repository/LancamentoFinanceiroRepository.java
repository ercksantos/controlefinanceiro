package com.erick.controlefinanceiro.repository;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import com.erick.controlefinanceiro.domain.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoFinanceiroRepository extends JpaRepository<LancamentoFinanceiro, Long> {

    // Buscar por tipo
    List<LancamentoFinanceiro> findByTipo(TipoLancamento tipo);

    // Buscar por categoria
    List<LancamentoFinanceiro> findByCategoria(String categoria);

    // Buscar por período (entre duas datas)
    List<LancamentoFinanceiro> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    // Buscar por tipo e período
    List<LancamentoFinanceiro> findByTipoAndDataBetween(TipoLancamento tipo, LocalDate dataInicio, LocalDate dataFim);

    // Buscar por categoria e período
    List<LancamentoFinanceiro> findByCategoriaAndDataBetween(String categoria, LocalDate dataInicio, LocalDate dataFim);

    // Buscar com filtros combinados (Query customizada)
    @Query("SELECT l FROM LancamentoFinanceiro l WHERE " +
           "(:tipo IS NULL OR l.tipo = :tipo) AND " +
           "(:categoria IS NULL OR l.categoria = :categoria) AND " +
           "(:dataInicio IS NULL OR l.data >= :dataInicio) AND " +
           "(:dataFim IS NULL OR l.data <= :dataFim)")
    List<LancamentoFinanceiro> findWithFilters(
            @Param("tipo") TipoLancamento tipo,
            @Param("categoria") String categoria,
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
}
