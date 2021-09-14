package es.codeurjc.books.services.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import es.codeurjc.books.dtos.requests.UpdateUserEmailRequestDto;
import es.codeurjc.books.dtos.requests.UserRequestDto;
import es.codeurjc.books.dtos.responses.UserResponseDto;
import es.codeurjc.books.exceptions.UserCanNotBeDeletedException;
import es.codeurjc.books.exceptions.UserNotFoundException;
import es.codeurjc.books.exceptions.UserWithSameNickException;
import es.codeurjc.books.models.User;
import es.codeurjc.books.repositories.CommentRepository;
import es.codeurjc.books.services.UserService;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceRestImpl {

    private Mapper mapper;
    private String usersServiceUrl;
    private RestTemplate restTemplate;
    private CommentRepository commentRepository;

    public UserServiceRestImpl(Mapper mapper, @Value("${users.service.url}") String usersServiceUrl,
        RestTemplate restTemplate, CommentRepository commentRepository) {
        this.mapper = mapper;
        this.usersServiceUrl = usersServiceUrl + "/api/v1/users";
        this.restTemplate = restTemplate;
        this.commentRepository = commentRepository;
    }

    public Collection<UserResponseDto> findAll() {

        ResponseEntity<List<UserResponseDto>> responseEntity = restTemplate.exchange(
            usersServiceUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {
            });

        return responseEntity.getBody();
    }

    public UserResponseDto save(UserRequestDto userRequestDto) {

        ResponseEntity<List<UserResponseDto>> responseEntity = restTemplate.exchange(
            usersServiceUrl + "/" + userRequestDto.getNick(),
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {
            });


        if (!Objects.requireNonNull(responseEntity.getBody()).isEmpty()) {
            throw new UserWithSameNickException();
        }


        User user = this.mapper.map(userRequestDto, User.class);

        restTemplate.postForEntity(
            usersServiceUrl,
            userRequestDto,
            UserResponseDto.class);

        return this.mapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto findById(long userId) {
        ResponseEntity<UserResponseDto> responseEntity = restTemplate.exchange(
            usersServiceUrl + "/" + userId,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {
            });

        return responseEntity.getBody();
    }

    public UserResponseDto findByNick(String userNick) {
        ResponseEntity<UserResponseDto> responseEntity = restTemplate.exchange(
            usersServiceUrl + "/" + userNick,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {
            });

        return responseEntity.getBody();
    }

    public UserResponseDto updateEmail(long userId, UpdateUserEmailRequestDto updateUserEmailRequestDto) {
        UserResponseDto user = findById(userId);
        if (!user.getEmail().equalsIgnoreCase(updateUserEmailRequestDto.getEmail())) {
            user.setEmail(updateUserEmailRequestDto.getEmail());
            user = this.save(new UserRequestDto(user.getNick(), updateUserEmailRequestDto.getEmail()));
        }
        return this.mapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto delete(long userId) {
        UserResponseDto user = this.findById(userId);

        if (user == null) {
            throw new UserNotFoundException();
        }

        if (!isEmpty(commentRepository.findByUserId(userId))) {
            throw new UserCanNotBeDeletedException();
        }

        ResponseEntity<UserResponseDto> responseEntity = restTemplate.exchange(
            usersServiceUrl + "/" + userId,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<>() {
            });

        return this.mapper.map(user, UserResponseDto.class);
    }

}
