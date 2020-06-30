package lt.codeacademy.repository;

import lt.codeacademy.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findArticlesByTag(String tag, Pageable pageable);

    Page<Article> findArticlesByThemeId(Long themeId, Pageable pageable);
}
