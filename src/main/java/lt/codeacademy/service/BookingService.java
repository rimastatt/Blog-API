package lt.codeacademy.service;

import lt.codeacademy.entity.Booking;
import lt.codeacademy.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking was not found"));
    }
}
