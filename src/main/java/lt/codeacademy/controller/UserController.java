package lt.codeacademy.controller;

import lt.codeacademy.dto.UserDTO;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(UserDTO.createUserEntityFromUserDTO(userDTO));
    }
}
