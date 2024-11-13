package com.arnaldo.desafio3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate ;
    private Integer children;

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
