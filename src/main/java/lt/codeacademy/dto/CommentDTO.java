package lt.codeacademy.dto;

import lombok.Data;
import lt.codeacademy.entity.Comment;

import java.time.LocalDateTime;;

@Data
public class CommentDTO {

    private String message;
    private Long articleId;
    private String userName;
    private LocalDateTime date;

    public CommentDTO(Comment comment) {
        this.message = comment.getMessage();
        this.userName = comment.getUser().getUsername();
        this.date = comment.getCreationDate();
    }

    public static Comment fromDtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setUser(null);
        comment.setMessage(commentDTO.getMessage());
        comment.setCreationDate(commentDTO.getDate());
        return comment;
    }
}
