package com.efectopadel.padeltour.repository;

import com.efectopadel.padeltour.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Puedes agregar métodos personalizados aquí si necesitas
    User findByEmail(String email);
}