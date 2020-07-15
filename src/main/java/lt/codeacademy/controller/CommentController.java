package lt.codeacademy.controller;

import lt.codeacademy.dto.CommentDTO;
import lt.codeacademy.entity.Comment;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.ArticleService;
import lt.codeacademy.service.CommentService;
import lt.codeacademy.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{articleId}")
    public List<CommentDTO> getAllCommentsByArticleId(@PathVariable Long articleId){
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        return comments.stream().map(CommentDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/{articleId}/new")
    public List<Comment> submitComment(@RequestBody CommentDTO commentDTO, @AuthenticationPrincipal User user, @PathVariable Long articleId){
        Comment newComment = CommentDTO.fromDtoToEntity(commentDTO);
        newComment.setUser(user);
        newComment.setArticle(articleService.getArticleById(articleId));
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        commentService.saveOrUpdateComment(newComment);
        comments.add(newComment);
        return comments;
    }
}
