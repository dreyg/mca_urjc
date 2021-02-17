package com.davidrey.practica.services;

import com.davidrey.practica.dtos.requests.BookRequestDto;
import com.davidrey.practica.dtos.requests.CommentRequestDto;
import com.davidrey.practica.dtos.responses.BookDetailsResponseDto;
import com.davidrey.practica.dtos.responses.BookResponseDto;
import com.davidrey.practica.dtos.responses.CommentResponseDto;
import com.davidrey.practica.models.Book;

import java.util.List;

public interface BookService {

    List<BookResponseDto> findAll();

    BookDetailsResponseDto save(BookRequestDto bookRequestDto);

    Book findById(long bookId);

    CommentResponseDto addComment(long bookId, CommentRequestDto commentRequestDto);

    void deleteComment(long bookId, long commentId);
}
