package com.davidrey.practica.controllers;

import com.davidrey.practica.dtos.requests.BookRequestDto;
import com.davidrey.practica.dtos.requests.CommentRequestDto;
import com.davidrey.practica.dtos.responses.BookDetailsResponseDto;
import com.davidrey.practica.dtos.responses.BookResponseDto;
import com.davidrey.practica.dtos.responses.CommentResponseDto;
import com.davidrey.practica.models.Book;
import com.davidrey.practica.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all books",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BookResponseDto.class)))})})
    @GetMapping("/")
    public List<BookResponseDto> getBooks() {
        return this.bookService.findAll();
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDetailsResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})
    @GetMapping("/{bookId}")
    public Book getBook(@Parameter(description = "id of book to be searched")
                                          @PathVariable long bookId) {
        return this.bookService.findById(bookId);
    }

    @Operation(summary = "Create a new book")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book to be created", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BookRequestDto.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDetailsResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid book attributes supplied",
                    content = @Content)})
    @PostMapping("/")
    public BookDetailsResponseDto createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return this.bookService.save(bookRequestDto);
    }

    @Operation(summary = "Add a comment to a book")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "comment to be added", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CommentRequestDto.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added comment to the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommentResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid comment attributes supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})
    @PostMapping("/{bookId}/comments/")
    public CommentResponseDto createComment(@Parameter(description = "identifier of the book to which the comment will be added")
                                            @PathVariable long bookId,
                                            @Valid @RequestBody CommentRequestDto commentRequestDto) {
        return this.bookService.addComment(bookId, commentRequestDto);
    }

    @Operation(summary = "Delete a comment from a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted comment from the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommentResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book or comment not found",
                    content = @Content)})
    @DeleteMapping("/{bookId}/comments/{commentId}")
    public void deleteComment(@Parameter(description = "identifier of the book to which the comment belongs")
                                            @PathVariable long bookId,
                                            @Parameter(description = "id of comment to be deleted")
                                            @PathVariable long commentId) {
        this.bookService.deleteComment(bookId, commentId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
