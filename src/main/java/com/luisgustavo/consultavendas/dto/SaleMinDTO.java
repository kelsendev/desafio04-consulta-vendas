package com.luisgustavo.consultavendas.dto;

import com.luisgustavo.consultavendas.entities.Sale;
import com.luisgustavo.consultavendas.projection.SaleMinProjection;


import java.time.LocalDate;

public class SaleMinDTO {
   //Atributos

    private Long id;
    private Double amount;
    private LocalDate date;

    public SaleMinDTO(Long id, LocalDate date, Double amount, String sellerName) {
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
    public SaleMinDTO(Sale entity) {
        id = entity.getId();
        amount = entity.getAmount();
        date = entity.getDate();
    }

    public SaleMinDTO(SaleMinProjection projection) {
        id = projection.getId();
        date = projection.getDate();
        amount = projection.getAmount();
    }

    //Getter e Setter

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

    @Override
    public String toString() {
        return "SaleMinDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
