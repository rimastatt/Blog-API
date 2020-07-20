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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "text", nullable = false, columnDefinition="LONGTEXT")
    private String text;

    @Column(name = "tag", nullable = false)
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
