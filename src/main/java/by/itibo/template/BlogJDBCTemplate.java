package by.itibo.template;

import by.itibo.dao.BlogDAO;
import by.itibo.mapper.BlogMapper;
import by.itibo.model.Blog;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BlogJDBCTemplate implements BlogDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, String text, Integer authorId) {
        String SQL = "insert into blog (name, text, authorId) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL, name, text, authorId);
        System.out.println("Created Record Name = " + name + " " + text + " " + authorId);
        return;
    }

    public Blog getBlog(Integer id) {
        String SQL = "select * from blog where id = ?";
        Blog blog = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new BlogMapper());
        return blog;
    }

    public List<Blog> listBlog() {
        String SQL = "select * from blog";
        List <Blog> blogs = jdbcTemplateObject.query(SQL,
                new BlogMapper());
        return blogs;
    }

    public void delete(Integer id) {
        String SQL = "delete from blog where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, String name) {
        String SQL = "update blog set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
