package lt.codeacademy.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "travel_class")
    private String travelClass;

    @Column(name = "check_in_date")
    private Date checkInDate;

    @Column(name= "check_out_date")
    private Date checkOutDate;

    @Column(name = "number_of_adults")
    private Integer numberOfAdults;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    @Column(name = "total_price")
    private Double totalPrice;
}
