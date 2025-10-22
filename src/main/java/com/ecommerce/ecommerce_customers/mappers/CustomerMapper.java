package com.ecommerce.ecommerce_customers.mappers;

import com.ecommerce.ecommerce_customers.dto.requests.CreateCustomerRequest;
import com.ecommerce.ecommerce_customers.dto.responses.CustomerResponse;
import com.ecommerce.ecommerce_customers.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerResponse toResponse(Customer customer);

    List<CustomerResponse> toResponses(List<Customer> customers);

    Customer toEntity(CreateCustomerRequest request);
}
