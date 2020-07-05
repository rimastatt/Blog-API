package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Trip;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TripDTO {

    private Double price;
    private String location;
    private Long id;
    private Long articleId;
    private Integer availability;
    private String fileName;

    public static List<TripDTO> toTripDtoList(List<Trip> trips) {
        List<TripDTO> tripsDTO = trips
                .stream()
                .map(trip -> {
                    TripDTO tripDTO = new TripDTO();
                    tripDTO.setAvailability(trip.getAvailability());
                    tripDTO.setId(trip.getId());
                    tripDTO.setLocation(trip.getLocation());
                    tripDTO.setFileName(trip.getFileName());
                    tripDTO.setPrice(trip.getPrice());
                    tripDTO.setArticleId(trip.getArticle().getId());
                    return tripDTO;
                }).collect(Collectors.toList());

        return tripsDTO;
    }
}
