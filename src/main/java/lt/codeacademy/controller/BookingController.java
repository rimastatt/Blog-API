package lt.codeacademy.controller;

import lt.codeacademy.entity.Booking;
import lt.codeacademy.entity.Trip;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.BookingService;
import lt.codeacademy.service.TripService;
import lt.codeacademy.service.UserService;
import org.springframework.web.bind.annotation.*;

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
                                 @RequestParam String travelClass
                                 ) {
        User user = userService.findUserByEmail(email);
        Trip trip = tripService.findTripByLocation(location);
        Booking booking = new Booking();
        booking.setTrip(trip);
        booking.setUser(user);
        booking.setTravelClass(travelClass);
        return bookingService.saveBooking(booking);
    }
}
