package com.davidrey.practica.services.impl;

import com.davidrey.practica.dtos.requests.UserRequestDto;
import com.davidrey.practica.dtos.responses.UserResponseDto;
import com.davidrey.practica.exceptions.UserNotFoundException;
import com.davidrey.practica.models.User;
import com.davidrey.practica.repositories.CommentRepository;
import com.davidrey.practica.repositories.UserRepository;
import com.davidrey.practica.services.UserService;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Mapper mapper;
    private CommentRepository commentRepository;
    private UserRepository userRepository;

    public UserServiceImpl(Mapper mapper, UserRepository userRepository, CommentRepository commentRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = this.mapper.map(userRequestDto, User.class);
        user = this.userRepository.save(user);
        return this.mapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto findById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        this.userRepository.delete(user);
    }

    @Override
    public ResponseEntity<User> replaceUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByNick(userRequestDto.getNick()).orElseThrow(UserNotFoundException::new);

        if (user != null) {
            user.setMail(userRequestDto.getMail());
            return ResponseEntity.ok(userRepository.save(user));
        }
        return null;
    }

}
