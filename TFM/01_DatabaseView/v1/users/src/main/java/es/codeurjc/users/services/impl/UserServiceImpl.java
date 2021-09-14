package es.codeurjc.users.services.impl;

import static org.springframework.util.CollectionUtils.isEmpty;

import es.codeurjc.users.dtos.requests.UserRequestDto;
import es.codeurjc.users.dtos.responses.UserCommentResponseDto;
import es.codeurjc.users.dtos.responses.UserResponseDto;
import es.codeurjc.users.exceptions.UserCanNotBeDeletedException;
import es.codeurjc.users.exceptions.UserWithSameNickException;
import es.codeurjc.users.repositories.UserRepository;
import es.codeurjc.users.services.UserService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.codeurjc.users.dtos.requests.UpdateUserEmailRequestDto;
import es.codeurjc.users.exceptions.UserNotFoundException;
import es.codeurjc.users.models.User;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private String monolithUrl;
    private Mapper mapper;
    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public UserServiceImpl(Mapper mapper, UserRepository userRepository, @Value ("${monolith.url}") String monolithUrl, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.monolithUrl = monolithUrl;
        this.restTemplate = restTemplate;
    }

    public Collection<UserResponseDto> findAll() {
        return this.userRepository.findAll().stream()
                .map(user -> this.mapper.map(user, UserResponseDto.class))
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

    @Override
    public UserResponseDto findByNick(String userNick) {
        User user = this.userRepository.findByNick(userNick).orElseThrow(UserNotFoundException::new);
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

    public UserResponseDto delete(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        ResponseEntity<List<UserCommentResponseDto>> responseEntity = restTemplate.exchange(
            monolithUrl + "/api/v1/users/" + userId+ "/comments",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {
            });
        List<UserCommentResponseDto> userCommentResponseDto = responseEntity.getBody();

        if (!isEmpty(userCommentResponseDto)) {
            throw new UserCanNotBeDeletedException();
        }

        this.userRepository.delete(user);
        return this.mapper.map(user, UserResponseDto.class);
    }

}
