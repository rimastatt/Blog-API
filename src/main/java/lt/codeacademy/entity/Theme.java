package lt.codeacademy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theme_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Override
    public String toString() {
        return null;
    }
}
