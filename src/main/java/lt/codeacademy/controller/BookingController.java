package lt.codeacademy.controller;

import lt.codeacademy.entity.Booking;
import lt.codeacademy.entity.Trip;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.BookingService;
import lt.codeacademy.service.TripService;
import lt.codeacademy.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
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
    public Booking submitBooking(@RequestParam String email,
                                 @RequestParam String location,
                                 @RequestParam String travelClass,
                                 @RequestParam String checkOutDate,
                                 @RequestParam String checkInDate,
                                 @RequestParam Integer adults,
                                 @RequestParam Integer children,
                                 @RequestParam Double totalPrice
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
    public List<Booking> getBookingsByUserId(@AuthenticationPrincipal User user){
        return bookingService.findBookingsByUserId(user.getId());
    }
}
