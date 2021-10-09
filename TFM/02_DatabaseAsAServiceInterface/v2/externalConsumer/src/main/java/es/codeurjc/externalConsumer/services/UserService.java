package es.codeurjc.externalConsumer.services;

import es.codeurjc.externalConsumer.dtos.responses.UserResponseDto;

import java.util.Collection;

public class UserService {

    Collection<UserResponseDto> findAll();

    UserResponseDto findById(long userId);
}
