package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Comment;

import java.time.LocalDateTime;;

@Data
public class CommentDTO {

    private String message;
    private Long articleId;
    private Long UserId;
    private LocalDateTime date;

    public CommentDTO(Comment comment) {
        this.message = comment.getMessage();
        //this.articleId = comment.getArticle().getId();
        this.UserId = comment.getUser().getId();
        this.date = comment.getCreationDate();
    }

    public static Comment fromDtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        //comment.setArticle(null);
        comment.setUser(null);
        comment.setMessage(commentDTO.getMessage());
        comment.setCreationDate(commentDTO.getDate());
        return comment;
    }
}
