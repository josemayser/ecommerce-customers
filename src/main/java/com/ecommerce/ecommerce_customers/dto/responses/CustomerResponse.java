package com.ecommerce.ecommerce_customers.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private UUID id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
