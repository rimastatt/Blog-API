package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Role;
import lt.codeacademy.entity.User;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private Set<String> roles;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;

    public UserDTO(){

    }

    public UserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.roles = user.getRoles()
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());
    }

   public static User createUserEntityFromUserDTO(UserDTO userDTO){
       User user = new User();
       user.setId(userDTO.getId());
       user.setEmail(userDTO.getEmail());
       user.setFirstName(userDTO.getFirstName());
       user.setLastName(userDTO.getLastName());
       user.setUsername(userDTO.getUsername());
       user.setPassword(userDTO.getPassword());
       return user;
   }

}
