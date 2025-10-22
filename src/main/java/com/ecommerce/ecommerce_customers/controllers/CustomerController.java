package com.ecommerce.ecommerce_customers.controllers;

import com.ecommerce.ecommerce_customers.dto.requests.CreateCustomerRequest;
import com.ecommerce.ecommerce_customers.dto.requests.GetCustomersByIdsRequest;
import com.ecommerce.ecommerce_customers.dto.responses.CustomerResponse;
import com.ecommerce.ecommerce_customers.exceptions.customers.CustomerNotFoundException;
import com.ecommerce.ecommerce_customers.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @PostMapping("/ids")
    public List<CustomerResponse> getCustomersByIds(@Valid @RequestBody GetCustomersByIdsRequest request) {
        return customerService.getCustomersByIds(request.getIds());
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable UUID id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }
}
