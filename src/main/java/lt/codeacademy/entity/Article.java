package lt.codeacademy.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="article")
    private List<Trip> trips = new ArrayList<>();

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "tag", nullable = false)
    private String tag;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "publish_date")
    private Date date;
}
