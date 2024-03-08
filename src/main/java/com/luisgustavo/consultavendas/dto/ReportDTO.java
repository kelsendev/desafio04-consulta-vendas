package com.luisgustavo.consultavendas.dto;

import com.luisgustavo.consultavendas.entities.Sale;

import java.time.LocalDate;

public class ReportDTO {
  //Atributos
    private  Long id;
    private Double amount;
    private LocalDate date;
    private  String sellerName;

    //Construtores

    public ReportDTO() {

    }

    public ReportDTO(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName;
    }

    public ReportDTO(Sale entity) {
        id = entity.getId();
        amount = entity.getAmount();
        date = entity.getDate();
        sellerName = entity.getSeller().getName();
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
