package by.itibo.template;

import by.itibo.dao.CommentDAO;
import by.itibo.mapper.CommentMapper;
import by.itibo.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CommentJDBCTemplate implements CommentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String text, Integer authorId, Integer blogId) {
        String SQL = "insert into comment (text, authorId, blogId) values (?, ?, ?)";

        jdbcTemplateObject.update(SQL, text, authorId, blogId);
        System.out.println("Created Record Name = " + text + " " + authorId + " " + blogId);
        return;
    }

    public Comment getComment(Integer id) {
        String SQL = "select * from comment where id = ?";
        Comment comment = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new CommentMapper());
        return comment;
    }

    public List<Comment> listComment() {
        String SQL = "select * from comment";
        List <Comment> comments = jdbcTemplateObject.query(SQL,
                new CommentMapper());
        return comments;
    }

    public void delete(Integer id) {
        String SQL = "delete from comment where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, String text) {
        String SQL = "update comment set text = ? where id = ?";
        jdbcTemplateObject.update(SQL, text, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }

    public List<Comment> getCommentsByBlogId(Integer id) {
        String SQL = "select * from comment where blogId = ?";
        List<Comment> comments = jdbcTemplateObject.query(SQL, new CommentMapper(), id);
        return comments;
    }

    public List<Comment> getCommentsByUserId(Integer id) {
        String SQL = "select * from comment where userId = ?";
        List<Comment> comments = jdbcTemplateObject.query(SQL, new CommentMapper(), id);
        return comments;
    }

}
