package lt.codeacademy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    @JsonIgnore
    private List<Trip> trips = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    @NotNull
    @Column(name = "Username", nullable = false, unique = true)
    @Size(min = 4, max = 20)
    private String username;

    @NotNull
    @Column(name = "Password", nullable = false)
    @Size(min = 4)
    private String password;

    @NotEmpty
    @Column(name = "First_name", nullable = false)
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Column(name = "Last_name", nullable = false)
    @Size(min = 2, max = 20)
    private String lastName;

    @NotNull
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "Age", nullable = false)
    private Integer age;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return null;
    }
}
