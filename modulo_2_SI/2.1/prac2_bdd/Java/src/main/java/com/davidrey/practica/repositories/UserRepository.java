package com.davidrey.practica.repositories;


import com.davidrey.practica.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByNick(String nick);
}
