package by.itibo.bean;

import by.itibo.model.Blog;
import by.itibo.model.Comment;
import by.itibo.model.User;
import by.itibo.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name="User")
@SessionScoped
public class UserBean {

    @ManagedProperty("#{userService}")
    private UserService us;

    private String login;
    private String name;
    private String surname;
    private List<Comment> comments;
    private List<Blog> blogs;

    public String userView() {
        User user = us.getUserById(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id")));
        login = user.getLogin();
        name = user.getName();
        surname = user.getSurname();
        comments = user.getComments();
        blogs = user.getBlogs();
        return "userPage?faces-redirect=true";
    }
    public String returnToMain() {
        return "main?faces-redirect=true";
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
