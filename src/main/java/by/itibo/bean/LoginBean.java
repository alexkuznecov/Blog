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
        for (User user : us.getUsers()) {
            if (us.getUserByLoginAndPassword(login,password)!=null) {
                name = user.getName();
                surname = user.getSurname();
                return "main?faces-redirect=true";
            } else {
                return "loginfailed?faces-redirect=true";
            }
        }
        return "Oops?faces-redirect=true";
    }

    public String returnLogin() {
        return "login?faces-redirect=true";
    }

    public String gotoRegister() {
        return "register?faces-redirect=true";
    }

    public String Registration() {
        for (User user: us.getUsers()) {
            if (user.getName().equals(name) && user.getSurname().equals(surname) || user.getLogin().equals(login))
                return "Oops?faces-redirect=true";
        }
        us.setUser(name,surname,login,password);
        return "login?faces-redirect=true";
    }

    public void setUs(UserService us) {
        this.us = us;
    }
}