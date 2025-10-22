package com.ecommerce.ecommerce_customers.services.impl;

import com.ecommerce.ecommerce_customers.dto.requests.CreateCustomerRequest;
import com.ecommerce.ecommerce_customers.dto.responses.CustomerResponse;
import com.ecommerce.ecommerce_customers.entities.Customer;
import com.ecommerce.ecommerce_customers.exceptions.customers.CustomerNotFoundException;
import com.ecommerce.ecommerce_customers.mappers.CustomerMapper;
import com.ecommerce.ecommerce_customers.repositories.CustomerRepository;
import com.ecommerce.ecommerce_customers.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toResponses(customers);
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> getCustomersByIds(List<UUID> ids) {
        List<Customer> customers = customerRepository.findAllById(ids);
        return customerMapper.toResponses(customers);
    }

    @Override
    public CustomerResponse getCustomerById(UUID id) throws CustomerNotFoundException {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found."));
        return customerMapper.toResponse(customer);
    }
}
