package lt.codeacademy.service;

import lt.codeacademy.entity.Trip;
import lt.codeacademy.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TripService  {

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips(){
         return tripRepository.findAll();
    }

    public List<Trip> getAllTripsByArticleId(Long articleId){
        return tripRepository.getTripsByArticleId(articleId);
    }
}
