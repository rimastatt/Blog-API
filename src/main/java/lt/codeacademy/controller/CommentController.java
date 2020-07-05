package lt.codeacademy.controller;

import lt.codeacademy.entity.Comment;
import lt.codeacademy.service.ArticleService;
import lt.codeacademy.service.CommentService;
import lt.codeacademy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comm")
public class CommentController {

    private UserService userService;
    private ArticleService articleService;
    private CommentService commentService;

    public CommentController(UserService userService, ArticleService articleService, CommentService commentService) {
        this.userService = userService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllCommentsByArticleId(Long articleId){
       return commentService.getCommentsByArticleId(articleId);
    }
}
