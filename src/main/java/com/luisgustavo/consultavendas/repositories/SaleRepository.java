package com.luisgustavo.consultavendas.repositories;

import com.luisgustavo.consultavendas.dto.ReportDTO;
import com.luisgustavo.consultavendas.entities.Sale;
import com.luisgustavo.consultavendas.projection.SumaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT new com.luisgustavo.consultavendas.dto.ReportDTO(obj.id, obj.amount, obj.date, obj.seller.name)" +
            " FROM Sale obj" +
            " WHERE obj.date BETWEEN :dataMinima AND :dataMaxima" +
            " AND UPPER(obj.seller.name) LIKE CONCAT('%', UPPER(:name), '%')")
    Page<List<ReportDTO>> searchReport(LocalDate dataMinima, LocalDate dataMaxima, String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT tb_seller.name AS sellerName, SUM(tb_sales.amount) AS total " +
            "FROM tb_sales " +
            "INNER JOIN tb_seller " +
            "ON tb_sales.seller_id = tb_seller.id " +
            "WHERE tb_sales.date BETWEEN :minima AND :maxima " +
            "GROUP BY tb_seller.name")
    List<SumaryProjection> searchSummary(LocalDate minima, LocalDate maxima);


}
