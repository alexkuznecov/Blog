package by.itibo.controller;

import by.itibo.model.User;
import by.itibo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mainBean")
@SessionScoped
public class MainBean {

    private static final Logger LOG = LoggerFactory.getLogger(MainBean.class);

    @ManagedProperty("#{userService}")
    private UserService userService;

    private User user;

    public MainBean() {
        user = new User();
    }

    public void get() {
        user = userService.getUserById(1);
        if (user != null) {
            LOG.info("---------------->" + user.toString() + "<----------------");
        } else {
            LOG.info("---------------->" + "Nothing to show" + "<----------------");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}