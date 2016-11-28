package by.itibo.service;

import by.itibo.model.Comment;
import by.itibo.template.CommentJDBCTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "commentService")
public class CommentService {

    private static final Logger LOG = LoggerFactory.getLogger(BlogService.class);

    @Autowired
    CommentJDBCTemplate commentJDBCTemplate;

    public void createComment(String text, Integer blogId, Integer userId) {
        try {
            commentJDBCTemplate.create(text, userId, blogId);
        } catch (Exception e) {
            LOG.error("Error creating " + e.getMessage());
        }
    }

    public List<Comment> getComments() {
        List<Comment> comments;
        try {
            comments = commentJDBCTemplate.listComment();
        } catch (Exception e) {
            comments = null;
        }
        return comments;
    }

    public List<Comment> getCommentsByBlogId(Integer id) {
        List<Comment> comments;
        try {
            comments = commentJDBCTemplate.getCommentsByBlogId(id);
        } catch (Exception e) {
            comments = null;
        }
        return comments;
    }

    public List<Comment> getCommentsByUserId(Integer id) {
        List<Comment> comments;
        try {
            comments = commentJDBCTemplate.getCommentsByUserId(id);
        } catch (Exception e) {
            comments = null;
        }
        return comments;
    }

}
