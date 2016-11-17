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

    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";

        jdbcTemplateObject.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    public Blog getBlog(Integer id) {
        String SQL = "select * from Blog where id = ?";
        Blog blog = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new BlogMapper());
        return blog;
    }

    public List<Blog> listBlog() {
        String SQL = "select * from Blog";
        List <Blog> blogs = jdbcTemplateObject.query(SQL,
                new BlogMapper());
        return blogs;
    }

    public void delete(Integer id) {
        String SQL = "delete from Blog where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, Integer age) {
        String SQL = "update Blog set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
