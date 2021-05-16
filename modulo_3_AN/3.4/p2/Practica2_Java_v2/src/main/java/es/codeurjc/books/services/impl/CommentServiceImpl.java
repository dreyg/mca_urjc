package es.codeurjc.books.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import es.codeurjc.books.dtos.responses.UserResponseDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.codeurjc.books.dtos.requests.CommentRequestDto;
import es.codeurjc.books.dtos.responses.CommentResponseDto;
import es.codeurjc.books.dtos.responses.UserCommentResponseDto;
import es.codeurjc.books.exceptions.BookNotFoundException;
import es.codeurjc.books.exceptions.CommentNotFoundException;
import es.codeurjc.books.exceptions.UserNotFoundException;
import es.codeurjc.books.models.Book;
import es.codeurjc.books.models.Comment;
import es.codeurjc.books.models.User;
import es.codeurjc.books.repositories.BookRepository;
import es.codeurjc.books.repositories.CommentRepository;
import es.codeurjc.books.repositories.UserRepository;
import es.codeurjc.books.services.CommentService;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentServiceImpl implements CommentService {

    @Value(value = "${user.ms.service}")
    private boolean useMsService;

    @Value(value = "${ms.url}")
    private String msBaseUri;

    @Autowired
    private RestTemplate restTemplate;

    private Mapper mapper;
    private CommentRepository commentRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(Mapper mapper, CommentRepository commentRepository, BookRepository bookRepository,
                              UserRepository userRepository) {
        this.mapper = mapper;
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public CommentResponseDto addComment(long bookId, CommentRequestDto commentRequestDto) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        User user = new User();
        if (useMsService) {
            user = fetchUserByNick(commentRequestDto.getUserNick());
        } else {
            user = this.userRepository.findByNick(commentRequestDto.getUserNick()).orElseThrow(UserNotFoundException::new);
        }

        Comment comment = this.mapper.map(commentRequestDto, Comment.class);
        comment.setBook(book);
        comment.setUser(user);
        comment = this.commentRepository.save(comment);
        return this.mapper.map(comment, CommentResponseDto.class);
    }

    public CommentResponseDto deleteComment(long bookId, long commentId) {
        Comment comment = this.commentRepository.findByBookIdAndId(bookId, commentId)
                .orElseThrow(CommentNotFoundException::new);
        this.commentRepository.delete(comment);
        return this.mapper.map(comment, CommentResponseDto.class);
    }

    public Collection<UserCommentResponseDto> getComments(long userId) {
        return this.commentRepository.findByUserId(userId).stream()
                .map(comment -> this.mapper.map(comment, UserCommentResponseDto.class))
                .collect(Collectors.toList());
    }

    private User fetchUserByNick(final String nick) {
        ResponseEntity<UserResponseDto> response = restTemplate.exchange(msBaseUri + nick, HttpMethod.GET, null,
                UserResponseDto.class);
        User user = this.mapper.map(response.getBody(), User.class);
        return user;
    }

}
