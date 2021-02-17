package com.davidrey.practica.controllers;

import com.davidrey.practica.dtos.requests.BookRequestDto;
import com.davidrey.practica.dtos.requests.CommentRequestDto;
import com.davidrey.practica.dtos.requests.UserRequestDto;
import com.davidrey.practica.dtos.responses.BookDetailsResponseDto;
import com.davidrey.practica.dtos.responses.BookResponseDto;
import com.davidrey.practica.dtos.responses.CommentResponseDto;
import com.davidrey.practica.dtos.responses.UserResponseDto;
import com.davidrey.practica.models.User;
import com.davidrey.practica.services.BookService;
import com.davidrey.practica.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all users",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))})})
    @GetMapping("/")
    public List<User> getUsers() {
        return this.userService.findAll();
    }

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user and her comments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping("/{userId}")
    public UserResponseDto getUser(@Parameter(description = "id of user to be searched")
                                          @PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @Operation(summary = "Create a new user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User to be created", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserRequestDto.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid user attributes supplied",
                    content = @Content),
            @ApiResponse(responseCode = "406", description = "Nick user exists",
                    content = @Content)})
    @PostMapping("/")
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return this.userService.save(userRequestDto);
    }

    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted user without comment associated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommentResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "406", description = "User with comments associates",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @DeleteMapping("/{userId}")
    public void deleteUser(@Parameter(description = "identifier of the user")
                                            @PathVariable Long userId) {
        this.userService.deleteUser(userId);
    }

    @Operation(summary = "Update information about user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User to be updated", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserRequestDto.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid user attributes supplied",
                    content = @Content)})
    @PutMapping("/")
    public ResponseEntity<User> replaceUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return this.userService.replaceUser(userRequestDto);
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
