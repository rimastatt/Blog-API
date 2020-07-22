package lt.codeacademy.controller;

import lt.codeacademy.dto.TripDTO;
import lt.codeacademy.service.TripService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<TripDTO> getAllTrips() {
        return TripDTO.toTripDtoList(tripService.getAllTrips());
    }

    @GetMapping("/trip/{id}")
    public List<TripDTO> getAllTripsByArticleId(@PathVariable Long id) {
        return TripDTO.toTripDtoList(tripService.getAllTripsByArticleId(id));
    }
}
