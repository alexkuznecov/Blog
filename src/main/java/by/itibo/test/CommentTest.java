package by.itibo.test;

import by.itibo.model.Comment;
import by.itibo.template.CommentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CommentTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CommentJDBCTemplate commentJDBCTemplate =
                (CommentJDBCTemplate)context.getBean("commentJDBCTemplate");

        List<Comment> comments = commentJDBCTemplate.getCommentsByBlogId(1);
        for (Comment record : comments) {
            System.out.print("ID : " + record.getId() );
            System.out.println(", Text : " + record.getText());
        }
    }

}
