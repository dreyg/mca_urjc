package es.codeurjc.books.services.impl;

import es.codeurjc.books.dtos.requests.BookRequestDto;
import es.codeurjc.books.dtos.responses.BookDetailsResponseDto;
import es.codeurjc.books.dtos.responses.BookResponseDto;
import es.codeurjc.books.dtos.responses.CommentResponseDto;
import es.codeurjc.books.dtos.responses.CommentUserResponseDto;
import es.codeurjc.books.dtos.responses.UserResponseDto;
import es.codeurjc.books.exceptions.BookNotFoundException;
import es.codeurjc.books.models.Book;
import es.codeurjc.books.models.Comment;
import es.codeurjc.books.models.User;
import es.codeurjc.books.repositories.BookRepository;
import es.codeurjc.books.repositories.UserRepository;
import es.codeurjc.books.services.BookService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private Mapper mapper;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private UserServiceRestImpl userServiceRest;

    @Value(value = "${use.users.service}")
    private boolean useService;

    public BookServiceImpl(Mapper mapper, BookRepository bookRepository,
        UserRepository userRepository, UserServiceRestImpl userServiceRest) {
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userServiceRest = userServiceRest;
    }

    public Collection<BookResponseDto> findAll() {
        return this.bookRepository.findAll().stream()
                .map(book -> this.mapper.map(book, BookResponseDto.class))
                .collect(Collectors.toList());
    }

    public BookDetailsResponseDto save(BookRequestDto bookRequestDto) {
        Book book = this.mapper.map(bookRequestDto, Book.class);
        book = this.bookRepository.save(book);
        return this.mapper.map(book, BookDetailsResponseDto.class);
    }

    public BookDetailsResponseDto findById(long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        BookDetailsResponseDto responseDto = mapper.map(book, BookDetailsResponseDto.class);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : book.getComments()) {
            CommentResponseDto commentResponseDto = new CommentResponseDto();
            commentResponseDto.setId(comment.getId());
            commentResponseDto.setComment(comment.getComment());
            commentResponseDto.setScore(comment.getScore());
            if (useService) {
                UserResponseDto user = userServiceRest.findById(comment.getUserId());
                if (user != null) {
                    CommentUserResponseDto commentUserResponseDto = mapper
                        .map(user, CommentUserResponseDto.class);
                    commentResponseDto.setUser(commentUserResponseDto);
                    commentResponseDtos.add(commentResponseDto);
                }
            } else {
                Optional<User> user = userRepository.findById(comment.getUserId());
                if (user.isPresent()) {
                    User presentUser = user.get();
                    CommentUserResponseDto commentUserResponseDto = mapper
                        .map(presentUser, CommentUserResponseDto.class);
                    commentResponseDto.setUser(commentUserResponseDto);
                    commentResponseDtos.add(commentResponseDto);
                }

            }
        }
        responseDto.setComments(commentResponseDtos);
        return responseDto;
    }

}
