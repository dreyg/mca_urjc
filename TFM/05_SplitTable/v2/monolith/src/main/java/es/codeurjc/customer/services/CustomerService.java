package es.codeurjc.customer.services;

import es.codeurjc.customer.dtos.requests.CustomerRequestDto;
import es.codeurjc.customer.dtos.responses.CustomerResponseDto;

import java.util.Collection;

public interface CustomerService {

    Collection<CustomerResponseDto> findAll();

    CustomerResponseDto save(CustomerRequestDto customerRequestDto);

    CustomerResponseDto findById(long customerId);

    CustomerResponseDto delete(long customerId);

}
