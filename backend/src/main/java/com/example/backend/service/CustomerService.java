package com.example.backend.service;

import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<CustomerDTO> getAllCustomers() {
        return repo.findAll().stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        return repo.findById(id).map(this::toDTO)
                   .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer existing = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        existing.setName(dto.getName());
        existing.setAddress(dto.getAddress());
        existing.setBirthDate(dto.getBirthDate());
        existing.setStage(dto.getStage());

        return toDTO(repo.save(existing));
    }

    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }

    public List<CustomerDTO> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name).stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    private CustomerDTO toDTO(Customer c) {
        return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getBirthDate(), c.getStage(), c.getCreatedBy(), c.getUpdatedBy());
    }

    private Customer toEntity(CustomerDTO dto) {
        return new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getBirthDate(), dto.getStage(),dto.getCreatedBy(), dto.getUpdatedBy());
    }
}

