package lt.codeacademy.service;

import lt.codeacademy.dto.UserDTO;
import lt.codeacademy.entity.User;
import lt.codeacademy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        return userRepository.save(user);
    }

    public User getUser(User user){
        if(user.getId() != null) {
            return userRepository.getOne(user.getId());
        }
        else return null;
    }
}
