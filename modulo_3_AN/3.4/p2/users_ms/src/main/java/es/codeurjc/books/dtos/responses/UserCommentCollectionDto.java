package es.codeurjc.books.dtos.responses;

import lombok.Data;

import java.util.Collection;

@Data
public class UserCommentCollectionDto {

    private Collection<UserCommentResponseDto> userCommentResponseDtoCollection;

}
