package com.erick.controlefinanceiro.controller;

import com.erick.controlefinanceiro.domain.TipoLancamento;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroRequestDTO;
import com.erick.controlefinanceiro.dto.LancamentoFinanceiroResponseDTO;
import com.erick.controlefinanceiro.service.LancamentoFinanceiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoFinanceiroController {

    @Autowired
    private LancamentoFinanceiroService service;

    @PostMapping
    public ResponseEntity<LancamentoFinanceiroResponseDTO> salvar(@Valid @RequestBody LancamentoFinanceiroRequestDTO requestDTO) {
        LancamentoFinanceiroResponseDTO responseDTO = service.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> listarTodos() {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.listarTodos();
        return ResponseEntity.ok(lancamentos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> buscarPorTipo(@PathVariable TipoLancamento tipo) {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.buscarPorTipo(tipo);
        return ResponseEntity.ok(lancamentos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> buscarPorCategoria(@PathVariable String categoria) {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.buscarPorCategoria(categoria);
        return ResponseEntity.ok(lancamentos);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> buscarPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.buscarPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(lancamentos);
    }

    @GetMapping("/filtros")
    public ResponseEntity<List<LancamentoFinanceiroResponseDTO>> buscarComFiltros(
            @RequestParam(required = false) TipoLancamento tipo,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<LancamentoFinanceiroResponseDTO> lancamentos = service.buscarComFiltros(tipo, categoria, dataInicio, dataFim);
        return ResponseEntity.ok(lancamentos);
    }
}
