package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.User;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

   public static User createUserEntityFromUserDTO(UserDTO userDTO){
       User user = new User();
       user.setId(userDTO.getId());
       user.setAge(userDTO.getAge());
       user.setEmail(userDTO.getEmail());
       user.setFirstName(userDTO.getFirstName());
       user.setLastName(userDTO.getLastName());
       user.setUsername(userDTO.getUsername());
       user.setPassword(userDTO.getPassword());
       return user;
   }
}
