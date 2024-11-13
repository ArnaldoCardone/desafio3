package com.arnaldo.desafio3.services;

import com.arnaldo.desafio3.dto.ClienteDTO;
import com.arnaldo.desafio3.entities.Cliente;
import com.arnaldo.desafio3.repositories.ClienteRepository;
import com.arnaldo.desafio3.services.exceptions.ResourceNotFindException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) {
        Page<Cliente> result = repository.findAll(pageable);
        return result.map(x -> new ClienteDTO(x));

    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {

        Cliente entity = new Cliente();
        CopyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new ClienteDTO(entity);

    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto) {
        try {
            Cliente entity = repository.getReferenceById(id);
            CopyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClienteDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFindException("Cliente não encontrado!");

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFindException("Cliente não encontrado!");
        }
        repository.deleteById(id);
    }

    private void CopyDtoToEntity(ClienteDTO dto, Cliente cli) {

        cli.setName(dto.getName());
        cli.setCpf(dto.getCpf());
        cli.setIncome(dto.getIncome());
        cli.setBirthDate(dto.getBirthDate());
        cli.setChildren(dto.getChildren());
    }
}
