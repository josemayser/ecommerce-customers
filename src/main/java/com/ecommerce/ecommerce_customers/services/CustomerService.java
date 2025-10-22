package com.ecommerce.ecommerce_customers.services;

import com.ecommerce.ecommerce_customers.dto.requests.CreateCustomerRequest;
import com.ecommerce.ecommerce_customers.dto.responses.CustomerResponse;
import com.ecommerce.ecommerce_customers.exceptions.customers.CustomerNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerResponse> getCustomers();

    CustomerResponse createCustomer(CreateCustomerRequest request);

    List<CustomerResponse> getCustomersByIds(List<UUID> ids);

    CustomerResponse getCustomerById(UUID id) throws CustomerNotFoundException;
}
