package lt.codeacademy.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty
    @Column(name = "location")
    private String location;

    @Column(name = "file_name")
    private String fileName;

    @NotEmpty
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "days", nullable = false)
    private int days;

    @NotEmpty
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "availability")
    private Integer availability;
}
