package by.itibo.service;

import by.itibo.model.User;
import by.itibo.template.UserJDBCTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "userService")
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

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

    public User getUserByLoginAndPassword(String login, String password) {
        User user;
        try {
            user = userJDBCTemplate.getUserByLoginAndPassword(login, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public void setUser(String name, String surname, String login, String password) {
        try {
            userJDBCTemplate.create(name, surname, login, password);
        } catch (Exception e) {
            LOG.error(e.toString());
        }
    }

    public Boolean getUserByLogin(String login) {
        Boolean retVal = false;
        try {
            if (userJDBCTemplate.getUserByLogin(login) != null) {
                retVal = true;
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return retVal;
    }

}
