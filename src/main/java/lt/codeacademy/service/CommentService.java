package lt.codeacademy.service;

import lt.codeacademy.entity.Article;
import lt.codeacademy.entity.Comment;
import lt.codeacademy.entity.User;
import lt.codeacademy.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ArticleService articleService;

    public CommentService(CommentRepository commentRepository, ArticleService articleService){
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    public List<Comment> getCommentsByArticleId(Long articleId){
       return commentRepository.findCommentsByArticleId(articleId);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

    public void saveOrUpdateComment(Comment comment){
        commentRepository.save(comment);
    }
}
