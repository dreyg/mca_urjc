package com.davidrey.practica.repositories;

import com.davidrey.practica.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {


}
