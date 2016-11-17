package by.itibo.mapper;

import by.itibo.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setBlogId(rs.getInt("blogId"));
        comment.setText(rs.getString("text"));
        comment.setAuthorId(rs.getInt("authorId"));
        return comment;
    }

}
