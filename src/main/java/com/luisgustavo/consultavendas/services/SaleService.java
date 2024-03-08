package com.luisgustavo.consultavendas.services;


import com.luisgustavo.consultavendas.dto.ReportDTO;
import com.luisgustavo.consultavendas.dto.SaleMinDTO;
import com.luisgustavo.consultavendas.dto.SumaryDTO;
import com.luisgustavo.consultavendas.entities.Sale;

import com.luisgustavo.consultavendas.projection.SumaryProjection;
import com.luisgustavo.consultavendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService {
   @Autowired
   private SaleRepository repository;

   public SaleMinDTO findById(Long id) {
       Optional<Sale> result = repository.findById(id);
       Sale entity = result.get();
       return  new SaleMinDTO(entity);
   }

    public Page<List<ReportDTO>> getReport(String dataInicial, String dataFinal, String name, Pageable pageable) {
        LocalDate dataMaxima = fomataDataMaxima(dataFinal);
        LocalDate dataMinima = formataDataMinima(dataInicial, dataMaxima);
        return repository.searchReport(dataMinima, dataMaxima, name, pageable);
    }

    public List<SumaryDTO> search2(String dataInicial, String dataFinal) {
        LocalDate dataMaxima = fomataDataMaxima(dataFinal);
        LocalDate dataMinima = formataDataMinima(dataInicial, dataMaxima);
        List<SumaryProjection> lista = repository.searchSummary(dataMinima, dataMaxima);
        List<SumaryDTO> lista2 = lista.stream().map(x -> new SumaryDTO(x)).collect(Collectors.toList());
        return lista2;
    }

    private LocalDate fomataDataMaxima(String dataFinal) {
        if (dataFinal == null || dataFinal.isBlank()) {
            return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        }
        return LocalDate.parse(dataFinal);
    }

    private LocalDate formataDataMinima(String inicio, LocalDate fim) {
        if (inicio == null || inicio.isBlank()) {
            return fim.minusYears(1L);
        }
        return LocalDate.parse(inicio);
    }
}
