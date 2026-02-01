package com.erick.controlefinanceiro.dto;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LancamentoFinanceiroMapper {

    // Converte RequestDTO para Entity
    public LancamentoFinanceiro toEntity(LancamentoFinanceiroRequestDTO requestDTO) {
        LancamentoFinanceiro entity = new LancamentoFinanceiro();
        entity.setDescricao(requestDTO.getDescricao());
        entity.setValor(requestDTO.getValor());
        entity.setTipo(requestDTO.getTipo());
        entity.setData(requestDTO.getData());
        entity.setCategoria(requestDTO.getCategoria());
        return entity;
    }

    // Converte Entity para ResponseDTO
    public LancamentoFinanceiroResponseDTO toResponseDTO(LancamentoFinanceiro entity) {
        LancamentoFinanceiroResponseDTO responseDTO = new LancamentoFinanceiroResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setDescricao(entity.getDescricao());
        responseDTO.setValor(entity.getValor());
        responseDTO.setTipo(entity.getTipo());
        responseDTO.setData(entity.getData());
        responseDTO.setCategoria(entity.getCategoria());
        return responseDTO;
    }

    // Converte lista de Entities para lista de ResponseDTOs
    public List<LancamentoFinanceiroResponseDTO> toResponseDTOList(List<LancamentoFinanceiro> entities) {
        return entities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
