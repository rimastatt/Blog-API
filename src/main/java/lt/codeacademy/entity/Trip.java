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

    @Column(name = "price")
    private double price;
}
