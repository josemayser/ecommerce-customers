package com.ecommerce.ecommerce_customers.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class GetCustomersByIdsRequest {
    @NotEmpty(message = "ids are required")
    private List<UUID> ids;
}
