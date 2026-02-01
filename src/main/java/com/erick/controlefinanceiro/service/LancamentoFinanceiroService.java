package com.erick.controlefinanceiro.service;

import com.erick.controlefinanceiro.domain.LancamentoFinanceiro;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroMapper;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroRequestDTO;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroResponseDTO;
import com.erick.controlefinanceiro.repository.LancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoFinanceiroService {

    @Autowired
    private LancamentoFinanceiroRepository repository;

    @Autowired
    private LancamentoFinanceiroMapper mapper;

    public LancamentoFinanceiroResponseDTO salvar(LancamentoFinanceiroRequestDTO requestDTO) {
        LancamentoFinanceiro entity = mapper.toEntity(requestDTO);
        LancamentoFinanceiro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public List<LancamentoFinanceiroResponseDTO> listarTodos() {
        List<LancamentoFinanceiro> entities = repository.findAll();
        return mapper.toResponseDTOList(entities);
    }
}
