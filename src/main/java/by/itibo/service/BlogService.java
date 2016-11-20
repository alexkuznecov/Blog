package by.itibo.service;

import by.itibo.model.Blog;
import by.itibo.template.BlogJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "blogService")
public class BlogService {

    @Autowired
    BlogJDBCTemplate blogJDBCTemplate;

    public Blog getBlogById(Integer id) {

        Blog blog = new Blog();

        return blog;
    }
}
