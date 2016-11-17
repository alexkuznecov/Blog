package by.itibo.dao;

import by.itibo.model.Comment;

import javax.sql.DataSource;
import java.util.List;

public interface CommentDAO {

    void setDataSource(DataSource ds);

    void create(String name, Integer age);

    Comment getComment(Integer id);

    List<Comment> listComment();

    void delete(Integer id);

    void update(Integer id, Integer age);

}
