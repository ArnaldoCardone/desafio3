package com.arnaldo.desafio3.services;

import com.arnaldo.desafio3.dto.ClienteDTO;
import com.arnaldo.desafio3.entities.Cliente;
import com.arnaldo.desafio3.repositories.ClienteRepository;
import com.arnaldo.desafio3.services.exceptions.ResourceNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFindException("Cliente não encontrado!"));
        return new ClienteDTO(cliente);
    }

}
