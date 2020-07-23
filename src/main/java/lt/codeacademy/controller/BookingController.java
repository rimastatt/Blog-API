package lt.codeacademy.controller;

import lt.codeacademy.dto.BookingDTO;
import lt.codeacademy.entity.Booking;
import lt.codeacademy.entity.Trip;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.BookingService;
import lt.codeacademy.service.TripService;
import lt.codeacademy.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;
    private UserService userService;
    private TripService tripService;

    public BookingController(BookingService bookingService, UserService userService, TripService tripService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.tripService = tripService;
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking submitBooking(@RequestParam @NotEmpty String email,
                                 @RequestParam @NotEmpty String location,
                                 @RequestParam @NotEmpty String travelClass,
                                 @RequestParam @NotEmpty String checkOutDate,
                                 @RequestParam @NotEmpty String checkInDate,
                                 @RequestParam @Min(1) @Max(9)Integer adults,
                                 @RequestParam @Min(1) @Max(9)Integer children,
                                 @RequestParam BigDecimal totalPrice
    ) throws ParseException {
        User user = userService.findUserByEmail(email);
        Trip trip = tripService.findTripByLocation(location);
        Booking booking = new Booking();
        booking.setTrip(trip);
        booking.setUser(user);
        booking.setTravelClass(travelClass);
        booking.setCheckInDate(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(checkInDate).getTime()));
        booking.setCheckOutDate(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDate).getTime()));
        booking.setNumberOfAdults(adults);
        booking.setNumberOfChildren(children);
        booking.setTotalPrice(totalPrice);
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/info")
    public List<BookingDTO> getBookingsByUserId(@AuthenticationPrincipal User user){
        List<Booking> bookings = bookingService.findBookingsByUserId(user.getId());
        return bookings.stream()
                .map(BookingDTO::new)
                .collect(Collectors.toList());
    }
}
