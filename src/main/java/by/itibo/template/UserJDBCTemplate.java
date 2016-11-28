package by.itibo.template;

import by.itibo.dao.UserDAO;
import by.itibo.mapper.UserMapper;
import by.itibo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserJDBCTemplate implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, String surname, String login, String password) {
        String SQL = "insert into user (name, surname, login, password) values (?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL, name, surname, login, password);
        System.out.println("Created Record Name = " + name + " " + surname + " " + login);
        return;
    }

    public User getUser(Integer id) {
        String SQL = "select * from user where id = ?";
        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new UserMapper());
        return user;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        String SQL = "select * from user where login = ? and password = ?";
        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{login, password}, new UserMapper());
        return user;
    }

    public List<User> listUsers() {
        String SQL = "select * from user";
        List <User> users = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return users;
    }

    public void delete(Integer id) {
        String SQL = "delete from user where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Integer id, String name) {
        String SQL = "update user set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }

}
