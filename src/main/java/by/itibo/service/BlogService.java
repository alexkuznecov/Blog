package by.itibo.service;

import by.itibo.model.Blog;
import by.itibo.model.Comment;
import by.itibo.template.BlogJDBCTemplate;
import by.itibo.template.CommentJDBCTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "blogService")
public class BlogService {

    private static final Logger LOG = LoggerFactory.getLogger(BlogService.class);

    @Autowired
    BlogJDBCTemplate blogJDBCTemplate;
    @Autowired
    CommentJDBCTemplate commentJDBCTemplate;

    public void createBlog(String name, String test, Integer authorId, List<Comment> comments) {
        try {
            blogJDBCTemplate.create(name, test, authorId);
            for (int i = 0; i < comments.size(); i++) {
                commentJDBCTemplate.create(comments.get(i).getText(), comments.get(i).getAuthorId(), comments.get(i).getBlogId());
            }
        } catch (Exception e) {
            LOG.error("Error creating " + e.getMessage());
        }
    }

    public void createBlogWithoutComments(String name, String test, Integer authorId) {
        try {
            blogJDBCTemplate.create(name, test, authorId);
        } catch (Exception e) {
            LOG.error("Error creating " + e.getMessage());
        }
    }

    public List<Blog> getBlogs() {
        List<Blog> blogs;
        try {
            blogs = blogJDBCTemplate.getBlogs();
        } catch (Exception e) {
            blogs = null;
        }
        return blogs;
    }

    public List<Blog> getBlogsWithComments() {
        List<Blog> blogs;
        try {
            blogs = blogJDBCTemplate.getBlogs();
            for (int i = 0; i < blogs.size(); i++) {
                blogs.get(i).setComments(commentJDBCTemplate.getCommentsByBlogId(blogs.get(i).getId()));
            }
        } catch (Exception e) {
            blogs = null;
        }
        return blogs;
    }

    public Blog getBlogByText(String text) {
        Blog blog;
        try {
            blog = blogJDBCTemplate.getBlogByText(text);
        } catch (Exception e) {
            blog = null;
        }
        return blog;
    }

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
        List<Comment> comments = new ArrayList<Comment>();
        try {
            blog = blogJDBCTemplate.getBlog(id);
            comments = commentJDBCTemplate.getCommentsByBlogId(id);
            blog.setComments(comments);
        } catch (Exception e) {
            blog = null;
        }
        return blog;
    }
}
