package by.itibo.dao;

import by.itibo.model.Blog;

import javax.sql.DataSource;
import java.util.List;

public interface BlogDAO {

    void setDataSource(DataSource ds);

    void create(String name, String text ,Integer authorId);

    Blog getBlog(Integer id);

    List<Blog> getBlogs();

    Blog getBlogByText(String text);

    void delete(Integer id);

    void update(Integer id, String name);
}
