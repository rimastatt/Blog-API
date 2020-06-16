package lt.codeacademy.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Picture")
    private String picture;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "text")
    private String text;

    @Column(name = "tag")
    private String tag;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "Publish_date")
    private Date date;

}
