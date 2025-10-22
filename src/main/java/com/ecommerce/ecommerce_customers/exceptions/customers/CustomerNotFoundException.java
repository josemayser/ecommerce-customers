package com.ecommerce.ecommerce_customers.exceptions.customers;

import com.ecommerce.ecommerce_customers.exceptions.EntityNotFoundException;

public class CustomerNotFoundException extends EntityNotFoundException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
