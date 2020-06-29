package lt.codeacademy.controller;

import lt.codeacademy.dto.ArticleDTO;
import lt.codeacademy.entity.Article;
import lt.codeacademy.entity.Theme;
import lt.codeacademy.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> getArticles() {
        List<Article> articlesEntity = articleService.getAllArticles();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article articleEntity : articlesEntity) {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(articleEntity.getId());
            articleDTO.setTag(articleEntity.getTag());
            articleDTO.setFileName(articleEntity.getFileName());
            articleDTO.setDescription(articleEntity.getDescription());
            articleDTO.setText(articleEntity.getText());
            articleDTO.setDate(articleEntity.getDate());
            articleDTO.setTitle(articleEntity.getTitle());
            articleDTO.setThemeId(articleEntity.getTheme().getId());
            articleDTOS.add(articleDTO);
        }
        return articleDTOS;
    }

    @GetMapping("{id}")
    public ArticleDTO getArticle(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setThemeId(article.getTheme().getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setDate(article.getDate());
        articleDTO.setText(article.getText());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setFileName(article.getFileName());
        articleDTO.setTag(article.getTag());

        return articleDTO;
    }

    @PostMapping("/article")
    public Article createArticle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "theme") Theme theme,
            @RequestParam(name = "picture", required = false) MultipartFile picture,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "text") String text,
            @RequestParam(name = "tag") String tag,
            @RequestParam(name = "date", required = false) Date date) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTag(tag);
        articleDTO.setDescription(description);
        articleDTO.setText(text);
        articleDTO.setDate(date);
        articleDTO.setTitle(title);
        articleDTO.setTheme(theme);
        return articleService.createArticle(articleDTO, picture);
    }
}
