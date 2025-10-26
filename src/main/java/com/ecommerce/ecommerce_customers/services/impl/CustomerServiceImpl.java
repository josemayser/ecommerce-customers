package com.ecommerce.ecommerce_customers.services.impl;

import com.ecommerce.ecommerce_customers.dto.requests.CreateCustomerRequest;
import com.ecommerce.ecommerce_customers.dto.responses.CustomerResponse;
import com.ecommerce.ecommerce_customers.entities.Customer;
import com.ecommerce.ecommerce_customers.exceptions.customers.CustomerNotFoundException;
import com.ecommerce.ecommerce_customers.mappers.CustomerMapper;
import com.ecommerce.ecommerce_customers.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    //private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> getCustomers() {
        //List<Customer> customers = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(
                UUID.randomUUID(),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                "123456",
                "Jose",
                "Mayser",
                "josemayser@gmail.com",
                "12345678"
        ));
        customers.add(new Customer(
                UUID.randomUUID(),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                "789123",
                "Al",
                "Calle",
                "alcalle@gmail.com",
                "91234567"
        ));
        customers.add(new Customer(
                UUID.randomUUID(),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                "456789",
                "Alex",
                "Domínguez",
                "alexdominguez@gmail.com",
                "89123456"
        ));
        customers.add(new Customer(
                UUID.randomUUID(),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                "987654",
                "Percy",
                "Tomichá",
                "percytomicha@gmail.com",
                "89123456"
        ));
        return customerMapper.toResponses(customers);
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
//        Customer customer = customerMapper.toEntity(request);
//        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        Customer savedCustomer = new Customer(
                UUID.randomUUID(),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                request.getIdentificationNumber(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhoneNumber()
        );
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> getCustomersByIds(List<UUID> ids) {
//        List<Customer> customers = customerRepository.findAllById(ids);
        List<Customer> customers = new ArrayList<>();
        return customerMapper.toResponses(customers);
    }

    @Override
    public CustomerResponse getCustomerById(UUID id) throws CustomerNotFoundException {
//        Customer customer = customerRepository
//                .findById(id)
//                .orElseThrow(() -> new CustomerNotFoundException("Customer not found."));
        Customer customer = new Customer(
                id,
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()),
                "987654",
                "Percy",
                "Tomichá",
                "percytomicha@gmail.com",
                "89123456"
        );
        return customerMapper.toResponse(customer);
    }
}
