package com.davidrey.practica.repositories;


import com.davidrey.practica.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {


}
