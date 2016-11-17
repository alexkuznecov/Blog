package by.itibo.mapper;

import by.itibo.model.Blog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogMapper implements RowMapper<Blog> {

    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getInt("id"));
        blog.setName(rs.getString("name"));
        blog.setText(rs.getString("text"));
        blog.setAuthorId(rs.getInt("authorId"));
        return blog;
    }
}
