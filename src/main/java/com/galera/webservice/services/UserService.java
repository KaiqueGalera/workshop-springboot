package com.galera.webservice.services;

import com.galera.webservice.dto.UserDTO;
import com.galera.webservice.entities.User;
import com.galera.webservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // para incluir no pacote de inj de dep automático do spring
public class UserService {

    private final UserRepository userRepository; // Aqui no caso n tem necessidade de fazer @Repository (msma coisa que @Service ou @Component)
                                            // pq o repository extends de uma classe JpaRepository que já está nas dep para @Autowire

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream().map(UserDTO::new)
                .toList();
    }

    public Optional<UserDTO> findById(Long id){
        return userRepository.findById(id)
                .map(UserDTO::new);
    }

    public UserDTO insert(UserDTO userDTO){
        User user = new User(
                null,
                userDTO.name(),
                userDTO.email(),
                userDTO.phone(),
                userDTO.password());

        user = userRepository.save(user);

        return new UserDTO(user);
    }
}
