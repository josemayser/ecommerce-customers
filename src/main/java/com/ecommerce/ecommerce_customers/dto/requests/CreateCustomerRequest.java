package com.ecommerce.ecommerce_customers.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCustomerRequest {
    @NotBlank(message = "The identification number is required")
    private String identificationNumber;

    @NotBlank(message = "The first name number is required")
    private String firstName;

    @NotBlank(message = "The last name number is required")
    private String lastName;

    @Email(message = "The email must be in a valid format")
    private String email;

    private String phoneNumber;
}
