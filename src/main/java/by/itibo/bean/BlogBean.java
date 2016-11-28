package by.itibo.bean;

import by.itibo.model.Blog;
import by.itibo.model.Comment;
import by.itibo.service.BlogService;
import by.itibo.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean(name="Blog")
@SessionScoped
public class BlogBean {

    @ManagedProperty("#{blogService}")
    private BlogService bs;

    @ManagedProperty("#{userService}")
    private UserService us;

    private String name;
    private String text;
    private String author;
    private List<Comment> comments;

    public String createBlog() {
        Blog blog = bs.getBlogById(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id")));
        name = blog.getName().replace("\"","");
        text = blog.getText();
        author = us.getUserById(blog.getAuthorId()).getName() + us.getUserById(blog.getAuthorId()).getSurname();
        comments = blog.getComments();
        return "currentBlog?faces-redirect=true";
    }

//    public String returnToMain() {
//        return "main?faces-redirect=true";
//    }

    public void setBs(BlogService bs) {
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
