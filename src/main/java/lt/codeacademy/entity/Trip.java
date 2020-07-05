package lt.codeacademy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="article_id")
    private Article article;

    @Column(name = "location")
    private String location;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private Integer availability;
}
