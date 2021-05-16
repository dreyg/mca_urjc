package es.codeurjc.books.services.impl;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import es.codeurjc.books.dtos.responses.UserCommentCollectionDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.codeurjc.books.dtos.requests.UpdateUserEmailRequestDto;
import es.codeurjc.books.dtos.requests.UserRequestDto;
import es.codeurjc.books.dtos.responses.UserResponseDto;
import es.codeurjc.books.dtos.responses.UserCommentResponseDto;
import es.codeurjc.books.exceptions.UserCanNotBeDeletedException;
import es.codeurjc.books.exceptions.UserNotFoundException;
import es.codeurjc.books.exceptions.UserWithSameNickException;
import es.codeurjc.books.models.User;
import es.codeurjc.books.repositories.UserRepository;
import es.codeurjc.books.services.UserService;
import org.springframework.web.client.RestTemplate;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    private Mapper mapper;
    private UserRepository userRepository;

    @Value(value = "${monolith.url}")
    private String monolithBaseUri;

    public UserServiceImpl(Mapper mapper, UserRepository userRepository) {
        RestTemplate restTemplate;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public Collection<UserResponseDto> findAll() {
        return this.userRepository.findAll().stream().map(user -> this.mapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    public UserResponseDto save(UserRequestDto userRequestDto) {
        if (this.userRepository.existsByNick(userRequestDto.getNick())) {
            throw new UserWithSameNickException();
        }
        User user = this.mapper.map(userRequestDto, User.class);
        user = this.userRepository.save(user);
        return this.mapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto findById(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.mapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto updateEmail(long userId, UpdateUserEmailRequestDto updateUserEmailRequestDto) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if (!user.getEmail().equalsIgnoreCase(updateUserEmailRequestDto.getEmail())) {
            user.setEmail(updateUserEmailRequestDto.getEmail());
            user = this.userRepository.save(user);
        }
        return this.mapper.map(user, UserResponseDto.class);
    }

    private Collection<UserCommentResponseDto> fetchUserComments(final long userId) {
        ResponseEntity<Collection<UserCommentResponseDto>> response = restTemplate.exchange(monolithBaseUri + userId + "/comments/", HttpMethod.GET, null,
                new ParameterizedTypeReference<Collection<UserCommentResponseDto>>(){});
        return response.getBody();
    }

    public UserResponseDto delete(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        Collection<UserCommentResponseDto> userCommentResponseDtos;

        userCommentResponseDtos = fetchUserComments(userId);

        if (userCommentResponseDtos.size()  > 0) {
            throw new UserCanNotBeDeletedException();
         }
        this.userRepository.delete(user);
         return this.mapper.map(user, UserResponseDto.class);
    }

    @Override
    public Collection<UserCommentResponseDto> getComments(long userId) {

        return fetchUserComments(userId);
    }

}
