package es.codeurjc.externalConsumer.services.impl;

import es.codeurjc.externalConsumer.dtos.responses.UserResponseDto;
import es.codeurjc.externalConsumer.exceptions.UserNotFoundException;
import es.codeurjc.externalConsumer.models.Order;
import es.codeurjc.externalConsumer.repositories.OrderRepository;
import es.codeurjc.externalConsumer.services.UserService;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Mapper mapper;
    private OrderRepository orderRepository;

    public UserServiceImpl(Mapper mapper, OrderRepository orderRepository) {
        this.mapper = mapper;
        this.orderRepository = orderRepository;
    }

    public Collection<UserResponseDto> findAll() {
        return this.orderRepository.findAll().stream()
                .map(user -> this.mapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    public UserResponseDto findById(long userId) {
        Order order = this.orderRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.mapper.map(user, UserResponseDto.class);
    }


}
