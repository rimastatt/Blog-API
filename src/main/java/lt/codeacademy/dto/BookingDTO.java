package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Booking;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class BookingDTO {

    @NotEmpty
    private String location;
    @NotEmpty
    private String travelClass;
    @NotEmpty
    private Date checkInDate;
    @NotEmpty
    private Date checkOutDate;
    @NotEmpty
    private Integer numberOfAdults;
    @NotEmpty
    private Integer numberOfChildren;
    private BigDecimal totalPrice;

    public BookingDTO(Booking booking) {
        this.location = booking.getTrip().getLocation();
        this.travelClass = booking.getTravelClass();
        this.checkInDate = booking.getCheckInDate();
        this.checkOutDate = booking.getCheckOutDate();
        this.numberOfAdults = booking.getNumberOfAdults();
        this.numberOfChildren = booking.getNumberOfChildren();
        this.totalPrice = booking.getTotalPrice();
    }
}
