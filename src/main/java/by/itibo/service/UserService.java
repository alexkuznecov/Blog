package by.itibo.service;

import by.itibo.model.User;
import by.itibo.template.UserJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "userService")
public class UserService {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;

    public User getUserById(Integer id) {
        User user;
        try {
            user = userJDBCTemplate.getUser(id);
        } catch (Exception e) {
            user = new User();
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        try {
            users = userJDBCTemplate.listUsers();
        } catch (Exception e) {
            users = new ArrayList<User>();
        }
        return users;
    }

}
