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

    public void create(String name, Integer age) {
        String SQL = "insert into Comment (name, age) values (?, ?)";

        jdbcTemplateObject.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    public Comment getComment(Integer id) {
        String SQL = "select * from Comment where id = ?";
        Comment comment = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new CommentMapper());
        return comment;
    }

    public List<Comment> listComment() {
        String SQL = "select * from Comment";
        List <Comment> comments = jdbcTemplateObject.query(SQL,
                new CommentMapper());
        return comments;
    }

    public void delete(Integer id) {
        String SQL = "delete from Comment where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, Integer age) {
        String SQL = "update Comment set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }

}
