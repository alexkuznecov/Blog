package by.itibo.test;

import by.itibo.model.User;
import by.itibo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        User user = userService.getUserById(1);

        System.out.println(user.toString());

        System.out.println("-----------------------------------------------------");

        List<User> users = userService.getUsers();

        for (User us : users) {
            System.out.println(us.toString());
        }
    }

}
