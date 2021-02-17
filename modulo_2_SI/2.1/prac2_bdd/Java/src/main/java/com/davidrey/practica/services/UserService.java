package com.davidrey.practica.services;

import com.davidrey.practica.dtos.requests.UserRequestDto;
import com.davidrey.practica.dtos.responses.UserResponseDto;
import com.davidrey.practica.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> findAll();

    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto findById(Long userId);

    void deleteUser(Long userId);

    ResponseEntity<User> replaceUser(UserRequestDto userRequestDto);
}
