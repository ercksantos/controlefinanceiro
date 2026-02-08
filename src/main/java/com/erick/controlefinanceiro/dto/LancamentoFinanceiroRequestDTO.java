package com.erick.controlefinanceiro.dto;

import com.erick.controlefinanceiro.domain.TipoLancamento;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoFinanceiroRequestDTO {

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 3, max = 255, message = "A descrição deve ter entre 3 e 255 caracteres")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "O tipo de lançamento é obrigatório")
    private TipoLancamento tipo;

    @NotNull(message = "A data é obrigatória")
    @PastOrPresent(message = "A data não pode ser futura")
    private LocalDate data;

    @NotBlank(message = "A categoria é obrigatória")
    @Size(min = 3, max = 100, message = "A categoria deve ter entre 3 e 100 caracteres")
    private String categoria;
}
