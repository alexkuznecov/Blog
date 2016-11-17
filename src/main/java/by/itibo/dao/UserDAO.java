package by.itibo.dao;

import by.itibo.model.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDAO {

    void setDataSource(DataSource ds);

    void create(String name, String surname, String login, String password);

    User getUser(Integer id);

    List<User> listUsers();

    void delete(Integer id);

    void update(Integer id, String name);

}
