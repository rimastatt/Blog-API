package lt.codeacademy.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class ArticleDTO {

    @NotNull
    private Long id;
    @NotNull
    private Long themeId;
    @NotNull
    private String title;
    @NotNull
    private String picture;
    @NotNull
    private String description;
    @NotNull
    private String text;
    @NotNull
    private String tag;
    private Date date;
}
