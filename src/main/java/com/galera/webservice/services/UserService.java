package com.galera.webservice.services;

import com.galera.webservice.entities.User;
import com.galera.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // para incluir no pacote de inj de dep automático do spring
public class UserService {
    @Autowired // INJ DE DEP
    private UserRepository userRepository; // Aqui no caso n tem necessidade de fazer @Repository (msma coisa que @Service ou @Component)
                                            // pq o repository extends de uma classe JpaRepository que já está nas dep para @Autowire
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow();
    }
}
