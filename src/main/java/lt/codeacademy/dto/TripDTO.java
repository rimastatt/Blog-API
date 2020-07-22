package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Trip;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TripDTO {

    private BigDecimal price;
    private String location;
    private Long id;
    private Long articleId;
    private String description;
    private Integer days;
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
                    tripDTO.setDescription(trip.getDescription());
                    tripDTO.setDays(trip.getDays());
                    tripDTO.setArticleId(trip.getArticle().getId());
                    return tripDTO;
                }).collect(Collectors.toList());

        return tripsDTO;
    }


}
