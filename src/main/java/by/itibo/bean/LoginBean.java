package by.itibo.bean;

import by.itibo.model.User;
import by.itibo.service.UserService;
import by.itibo.template.BlogJDBCTemplate;
import by.itibo.template.UserJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

// Аннотации managed bean компонента
@ManagedBean (name="Login") // определение managed bean и его наименования
@SessionScoped             // определение времени жизни - сессия
public class LoginBean
{
    @ManagedProperty("#{userService}")
    private UserService us;

    private String login;
    private String password;
    private String name;
    private String surname;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    /* Метод простейшей авторизации.
    * Выполняется проверка имени и пароля пользователя.
    * Результат проверки - наименование страницы перехода
    */
    public String checkLogin() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        for (User user : us.getUsers()) {
            if (login.equalsIgnoreCase(user.getLogin()) && password.equalsIgnoreCase(user.getPassword())) {
                name = user.getName();
                surname = user.getSurname();
                return "loginsuccess?faces-redirect=true";
            } else {
                return "loginfailed?faces-redirect=true";
            }
        }
        return "Oops?faces-redirect=true";
    }

    public void setUs(UserService us) {
        this.us = us;
    }
}