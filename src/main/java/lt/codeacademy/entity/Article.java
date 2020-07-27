package lt.codeacademy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "article")
    @JsonIgnore
    private List<Trip> trips = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "file_name")
    private String fileName;

    @NotNull
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @NotNull
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @NotNull
    @Column(name = "tag")
    private String tag;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "publish_date")
    private Date date;

    @Override
    public String toString() {
        return null;
    }
}
