package lt.codeacademy.controller;

import lt.codeacademy.dto.UserDTO;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDTO getUser(@AuthenticationPrincipal User user){
        return new UserDTO(user);
    }

    @PostMapping("/new")
    public User createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.saveUser(UserDTO.createUserEntityFromUserDTO(userDTO));
    }

    @PostMapping("/userInfo")
    public User updateUser(@RequestBody @Valid UserDTO userDTO){
        return userService.saveUser(UserDTO.createUserEntityFromUserDTO(userDTO));
    }
}
