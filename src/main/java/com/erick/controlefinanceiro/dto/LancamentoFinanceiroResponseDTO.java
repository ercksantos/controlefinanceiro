package com.erick.controlefinanceiro.dto;

import com.erick.controlefinanceiro.domain.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoFinanceiroResponseDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private LocalDate data;
    private String categoria;
}
