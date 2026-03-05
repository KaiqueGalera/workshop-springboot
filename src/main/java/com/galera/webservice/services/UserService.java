package com.galera.webservice.services;

import com.galera.webservice.dto.UserDTO;
import com.galera.webservice.domain.User;
import com.galera.webservice.repository.UserRepository;
import com.galera.webservice.services.exceptions.DataBaseException;
import com.galera.webservice.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserDTO findById(Long id){
        return userRepository.findById(id)
                .map(UserDTO::new).orElseThrow(()-> new ResourceNotFoundException(id));
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

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));

       try {
           userRepository.delete(user);
       } catch (DataIntegrityViolationException e) {
           throw new DataBaseException(e.getMessage());
       }
    }

    public UserDTO update(Long id, UserDTO userDTO){
        User user = userRepository.getReferenceById(id); //melhor do que usar o findbyid pq ele n trás o obj, ele "prepara" ele, mais otimizado (depois vc decide oq fazer)
        updateData(user, userDTO);

        UserDTO userDTO1 = new UserDTO(user);
        userRepository.save(user);

        return new UserDTO(user);
    }

    private void updateData(User entity, UserDTO userDTO){
        User user = new User(
                userDTO.id(),
                userDTO.name(),
                userDTO.email(),
                userDTO.phone(),
                userDTO.password()
        );

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());

    }
}
