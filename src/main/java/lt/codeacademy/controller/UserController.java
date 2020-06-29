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
    public User createUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password)") String password,
                           @RequestParam(name = "firstName") String firsName,
                           @RequestParam(name = "lastName") String lastName,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "age") Integer age) {

        UserDTO userDTO = new UserDTO();
        userDTO.setAge(age);
        userDTO.setEmail(email);
        userDTO.setFirstName(firsName);
        userDTO.setLastName(lastName);
        userDTO.setPassword(password);
        userDTO.setUsername(username);
        return userService.saveUser(userDTO);
    }
}
