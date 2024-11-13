package com.arnaldo.desafio3.dto;

import com.arnaldo.desafio3.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteDTO {

    private long id;

    @NotBlank(message = "Nome não pode ser em branco")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Data não pode ser futura")
    private LocalDate birthDate ;
    private Integer children;

    public ClienteDTO(long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.cpf = cliente.getCpf();
        this.income = cliente.getIncome();
        this.birthDate = cliente.getBirthDate();
        this.children = cliente.getChildren();
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
