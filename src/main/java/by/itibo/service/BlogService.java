package by.itibo.service;

import by.itibo.model.Blog;
import by.itibo.template.BlogJDBCTemplate;
import by.itibo.template.CommentJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "blogService")
public class BlogService {

    @Autowired
    BlogJDBCTemplate blogJDBCTemplate;
    @Autowired
    CommentJDBCTemplate commentJDBCTemplate;

    public Blog getBlogById(Integer id) {
        Blog blog;
        try {
            blog = blogJDBCTemplate.getBlog(id);
        } catch (Exception e) {
            blog = null;
        }
        return blog;
    }
    public Blog getBlogWithCommentsById(Integer id) {
        Blog blog = new Blog();
        try {
            blog = blogJDBCTemplate.getBlog(id);

        } catch (Exception e) {
            blog = null;
        }
        return blog;
    }
}
