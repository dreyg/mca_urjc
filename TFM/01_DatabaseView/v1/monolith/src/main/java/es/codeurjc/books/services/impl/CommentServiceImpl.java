package es.codeurjc.books.services.impl;

import es.codeurjc.books.dtos.requests.CommentRequestDto;
import es.codeurjc.books.dtos.responses.CommentResponseDto;
import es.codeurjc.books.dtos.responses.CommentUserResponseDto;
import es.codeurjc.books.dtos.responses.UserCommentResponseDto;
import es.codeurjc.books.dtos.responses.UserResponseDto;
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
import java.util.Collection;
import java.util.stream.Collectors;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private Mapper mapper;
    private CommentRepository commentRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private UserServiceRestImpl userServiceRest;

    @Value(value = "${use.users.service}")
    private boolean useService;

    public CommentServiceImpl(Mapper mapper, CommentRepository commentRepository, BookRepository bookRepository,
                              UserRepository userRepository, UserServiceRestImpl userServiceRest) {
        this.mapper = mapper;
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userServiceRest = userServiceRest;
    }

    public CommentResponseDto addComment(long bookId, CommentRequestDto commentRequestDto) {

        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Comment comment = this.mapper.map(commentRequestDto, Comment.class);
        comment.setBook(book);

        if (useService) {
            UserResponseDto userResponseDto = this.userServiceRest
                .findByNick(commentRequestDto.getUserNick());
            if (userResponseDto == null) {
                throw new UserNotFoundException();
            }
            comment.setId(userResponseDto.getId());
        } else {
            User user = this.userRepository.findByNick(commentRequestDto.getUserNick())
                .orElseThrow(UserNotFoundException::new);
            comment.setId(user.getId());
        }

        comment = this.commentRepository.save(comment);
        return this.mapper.map(comment, CommentResponseDto.class);
    }

    public CommentResponseDto deleteComment(long bookId, long commentId) {
        Comment comment = this.commentRepository.findByBookIdAndId(bookId, commentId)
                .orElseThrow(CommentNotFoundException::new);
        CommentResponseDto commentResponseDto = this.mapper.map(comment, CommentResponseDto.class);

        if (useService) {
            UserResponseDto userResponseDto = this.userServiceRest
                .findById(comment.getUserId());
            if (userResponseDto == null) {
                throw new UserNotFoundException();
            }
            CommentUserResponseDto commentUserResponseDto = new CommentUserResponseDto();
            commentUserResponseDto.setNick(userResponseDto.getNick());
            commentUserResponseDto.setEmail(userResponseDto.getEmail());
            commentResponseDto.setUser(commentUserResponseDto);
        } else {
            User user = this.userRepository.findById(comment.getUserId()).orElseThrow(UserNotFoundException::new);
            comment.setId(user.getId());
            CommentUserResponseDto commentUserResponseDto = new CommentUserResponseDto();
            commentUserResponseDto.setNick(user.getNick());
            commentUserResponseDto.setEmail(user.getEmail());
            commentResponseDto.setUser(commentUserResponseDto);
        }

        this.commentRepository.delete(comment);
        return commentResponseDto;
    }

    public Collection<UserCommentResponseDto> getComments(long userId) {
        return this.commentRepository.findByUserId(userId).stream()
                .map(comment -> this.mapper.map(comment, UserCommentResponseDto.class))
                .collect(Collectors.toList());
    }

}
