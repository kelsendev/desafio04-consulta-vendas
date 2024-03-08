package com.luisgustavo.consultavendas.dto;

import com.luisgustavo.consultavendas.projection.SumaryProjection;

public class SumaryDTO {
 //Atributos
    private  String sellerName;
    private Double total;

    //Construtores
    public SumaryDTO() {

    }

    public SumaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }
    public SumaryDTO(SumaryProjection proj) {
        sellerName = proj.getSellerName();
        total = proj.getTotal();
    }

   

    //Getters e Setters
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
