package lt.codeacademy.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @NotNull
    @Column(name = "travel_class")
    private String travelClass;

    @NotNull
    @Column(name = "check_in_date")
    private Date checkInDate;

    @NotNull
    @Column(name= "check_out_date")
    private Date checkOutDate;

    @Column(name = "number_of_adults")
    @Max(value = 9, message = "Cannot book more than 9 adults")
    private Integer numberOfAdults;

    @Column(name = "number_of_children")
    @Max(value = 9, message = "Cannot book more than 9 children")
    private Integer numberOfChildren;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
