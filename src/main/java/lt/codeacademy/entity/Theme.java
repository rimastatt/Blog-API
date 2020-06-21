package lt.codeacademy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theme_id")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="theme")
    private List<Article> articles = new ArrayList();

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "picture")
    private String picture;

}
