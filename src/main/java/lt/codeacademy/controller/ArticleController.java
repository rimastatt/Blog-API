package lt.codeacademy.controller;

import lt.codeacademy.dto.ArticleDTO;
import lt.codeacademy.entity.Article;
import lt.codeacademy.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<Article> articlesEntity =  articleService.getAllArticles();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for(Article articleEntity : articlesEntity){
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(articleEntity.getId());
            articleDTO.setTag(articleEntity.getTag());
            articleDTO.setPicture(articleEntity.getPicture());
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
    public ArticleDTO getArticle(@PathVariable Long id){
       Article article = articleService.getArticleById(id);
       ArticleDTO articleDTO = new ArticleDTO();
       articleDTO.setId(article.getId());
       articleDTO.setThemeId(article.getTheme().getId());
       articleDTO.setTitle(article.getTitle());
       articleDTO.setDate(article.getDate());
       articleDTO.setText(article.getText());
       articleDTO.setDescription(article.getDescription());
       articleDTO.setPicture(article.getPicture());
       articleDTO.setTag(article.getTag());
       return articleDTO;
    }
}
