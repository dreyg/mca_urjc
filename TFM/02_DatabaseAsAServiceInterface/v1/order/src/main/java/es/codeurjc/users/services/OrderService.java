package es.codeurjc.users.services;

import es.codeurjc.users.dtos.requests.OrderRequestDto;
import es.codeurjc.users.dtos.responses.OrderResponseDto;

import java.util.Collection;

public interface OrderService {

    Collection<OrderResponseDto> findAll();

    OrderResponseDto save(OrderRequestDto orderRequestDto);

    OrderResponseDto findById(long userId);

    OrderResponseDto delete(long userId);

}
