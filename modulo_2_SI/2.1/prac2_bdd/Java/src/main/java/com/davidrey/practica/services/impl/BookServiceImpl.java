package com.davidrey.practica.services.impl;

import com.davidrey.practica.dtos.requests.BookRequestDto;
import com.davidrey.practica.dtos.requests.CommentRequestDto;
import com.davidrey.practica.dtos.responses.BookDetailsResponseDto;
import com.davidrey.practica.dtos.responses.BookResponseDto;
import com.davidrey.practica.dtos.responses.CommentResponseDto;
import com.davidrey.practica.exceptions.BookNotFoundException;
import com.davidrey.practica.exceptions.CommentNotFoundException;
import com.davidrey.practica.exceptions.UserNotFoundException;
import com.davidrey.practica.models.Book;
import com.davidrey.practica.models.Comment;
import com.davidrey.practica.models.User;
import com.davidrey.practica.repositories.BookRepository;
import com.davidrey.practica.repositories.CommentRepository;
import com.davidrey.practica.repositories.UserRepository;
import com.davidrey.practica.services.BookService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Mapper mapper;
    @Autowired private BookRepository bookRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private UserRepository userRepository;

    public BookServiceImpl(Mapper mapper, BookRepository bookRepository, CommentRepository commentRepository) {
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    public List<BookResponseDto> findAll() {
        List<Book> bookList = this.bookRepository.findAll();
        List<BookResponseDto> responseList = new ArrayList<>();
        for (Book book : bookList){
            responseList.add(this.mapper.map(book, BookResponseDto.class));
        }
        return responseList;
    }

    public BookDetailsResponseDto save(BookRequestDto bookRequestDto) {
        Book book = this.mapper.map(bookRequestDto, Book.class);
        book = this.bookRepository.save(book);
        return this.mapper.map(book, BookDetailsResponseDto.class);
    }

    public Book findById(long bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        //return this.mapper.map(book, BookDetailsResponseDto.class);
    }

    public CommentResponseDto addComment(long bookId, CommentRequestDto commentRequestDto) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Comment comment = this.mapper.map(commentRequestDto, Comment.class);
        comment.setBook(book);
        User user = this.userRepository.findByNick(comment.getUser().getNick()).orElseThrow(UserNotFoundException::new);
        comment.setUser(user);
        comment = this.commentRepository.save(comment);
        return this.mapper.map(comment, CommentResponseDto.class);
    }

    public void deleteComment(long bookId, long commentId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        if (book != null) {
            this.commentRepository.deleteById(commentId);
        }
    }

}
