package com.luisgustavo.consultavendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_seller")
public class Seller {
   //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    @JoinColumn(unique = true)
    private String email;
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<Sale> sales = new ArrayList<>();

    //Construtores
    public Seller() {

    }

    public Seller(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
