package com.nozerry.ecommerce.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {


    public Customer toCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .address(Address.builder()
                        .street(customerRequest.address().getStreet())
                        .houseNumber(customerRequest.address().getHouseNumber())
                        .zipCode(customerRequest.address().getZipCode())
                        .build())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
