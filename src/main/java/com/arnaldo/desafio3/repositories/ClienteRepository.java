package com.arnaldo.desafio3.repositories;

import com.arnaldo.desafio3.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
