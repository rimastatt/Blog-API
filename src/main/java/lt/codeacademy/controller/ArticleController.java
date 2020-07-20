package lt.codeacademy.controller;

import lt.codeacademy.dto.ArticleDTO;
import lt.codeacademy.dto.CommentDTO;
import lt.codeacademy.entity.Article;
import lt.codeacademy.entity.Comment;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.ArticleService;
import lt.codeacademy.service.CommentService;
import lt.codeacademy.service.ThemeService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;
    private final ThemeService themeService;

    public ArticleController(ArticleService articleService, CommentService commentService, ThemeService themeService) {
        this.commentService = commentService;
        this.themeService = themeService;
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> getAllArticles(@RequestParam(defaultValue = "0") int pageNumber,
                                           @RequestParam(name = "pageSize") int pageSize) {
        Page<Article> articlesEntityPage = articleService.getAllArticles(pageNumber, pageSize);
        List<Article> articlesEntity = articlesEntityPage.getContent();
        return ArticleDTO.fromArticleEntityListToDTO(articlesEntity);
    }

    @GetMapping("{themeId}")
    public List<ArticleDTO> getArticlesByTheme(@PathVariable(required = false) Long themeId,
                                               @RequestParam(defaultValue = "0") int pageNumber,
                                               @RequestParam(name = "pageSize") int pageSize) {
        Page<Article> articlesEntityPage = articleService.getAllArticlesByTheme(pageNumber, themeId, pageSize);
        List<Article> articlesEntity = articlesEntityPage.getContent();
        return ArticleDTO.fromArticleEntityListToDTO(articlesEntity);

    }

    @GetMapping("/article/{id}")
    public ArticleDTO getArticle(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        return ArticleDTO.fromArticleEntityToDTO(article);
    }

    @PostMapping("/article/new")

    public Article createArticle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "theme") Long theme,
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
        articleDTO.setTheme(themeService.findThemeById(theme));
        return articleService.createArticle(ArticleDTO.fromArticleDtoToArticleEntity(articleDTO), picture);
    }

    @CrossOrigin
    @DeleteMapping("/article/{id}/delete")
    public void deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/article/{articleId}/comments")
    public List<CommentDTO> getAllCommentsByArticleId(@PathVariable Long articleId) {
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        return comments.stream().map(CommentDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/article/{articleId}")
    public Comment submitComment(@RequestBody Comment comment, @AuthenticationPrincipal User user, @PathVariable Long articleId) {
        comment.setArticle(articleService.getArticleById(articleId));
        comment.setUser(user);
        return commentService.saveOrUpdateComment(comment);

    } 

//    @GetMapping("{tag}")
//    public Page<Article> getAllArticlesByTag(@RequestParam String tag, @RequestParam(defaultValue = "0") int pageNumber) {
//        return articleService.getAllArticlesByTag(pageNumber, tag);
//    }
}
