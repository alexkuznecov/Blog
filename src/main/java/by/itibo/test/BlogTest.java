package by.itibo.test;

import by.itibo.model.Blog;
import by.itibo.service.BlogService;
import by.itibo.template.BlogJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BlogTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BlogJDBCTemplate blogJDBCTemplate =
                (BlogJDBCTemplate)context.getBean("blogJDBCTemplate");

        BlogService blogService = (BlogService) context.getBean("blogService");

        List<Blog> blogs = blogService.getBlogsWithComments();
        for (Blog record : blogs) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Text : " + record.getText());
        }

    }

}
