package lt.codeacademy.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ThemeDTO {

    private Long id;
    private List<Long> articlesId = new ArrayList();
    private String name;
    private String description;
}
