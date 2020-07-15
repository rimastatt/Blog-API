package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Article;
import lt.codeacademy.entity.Theme;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data

public class ArticleDTO {

    private Long id;
    private Long themeId;
    private String title;
    private String fileName;
    private String description;
    private String text;
    private String tag;
    private Date date;
    private Theme theme;

    public ArticleDTO(){
    }

    public static List<ArticleDTO> fromArticleEntityListToDTO(List<Article> articleEntityList) {
        List<ArticleDTO> articleDTOS = articleEntityList
                .stream()
                .map(articleEntity -> {
                    ArticleDTO articleDTO = new ArticleDTO();
                    articleDTO.setId(articleEntity.getId());
                    articleDTO.setFileName(articleEntity.getFileName());
                    articleDTO.setTitle(articleEntity.getTitle());
                    articleDTO.setThemeId(articleEntity.getTheme().getId());
                    articleDTO.setDate(articleEntity.getDate());
                    articleDTO.setText(articleEntity.getText());
                    articleDTO.setTag(articleEntity.getTag());
                    articleDTO.setDescription(articleEntity.getDescription());
                    return articleDTO;
                })
                .collect(Collectors.toList());
        return articleDTOS;
    }

    public static ArticleDTO fromArticleEntityToDTO(Article articleEntity) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(articleEntity.getId());
        articleDTO.setFileName(articleEntity.getFileName());
        articleDTO.setTitle(articleEntity.getTitle());
        articleDTO.setThemeId(articleEntity.getTheme().getId());
        articleDTO.setDate(articleEntity.getDate());
        articleDTO.setText(articleEntity.getText());
        articleDTO.setTag(articleEntity.getTag());
        articleDTO.setDescription(articleEntity.getDescription());
        return articleDTO;
    }

    public static Article fromArticleDtoToArticleEntity(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setText(articleDTO.getText());
        article.setTheme(articleDTO.getTheme());
        article.setTag(articleDTO.getTag());
        article.setDescription(articleDTO.getDescription());
        return article;
    }

    @Override
    public String toString() {
        return null;
    }
}
