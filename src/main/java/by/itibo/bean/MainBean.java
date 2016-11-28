package by.itibo.bean;

import by.itibo.model.Blog;
import by.itibo.service.BlogService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="Main") // определение managed bean и его наименования
@SessionScoped
public class MainBean {

    @ManagedProperty("#{blogService}")
    private BlogService bs;

    private List<Blog> bloges;


   @PostConstruct
   public void init() {
       bloges = new ArrayList<Blog>();
       bloges = bs.getBlogs();
   }

    public void setBs(BlogService bs) {
        this.bs = bs;
    }

    public List<Blog> getBloges() {
        return bloges;
    }

    public void setBloges(List<Blog> bloges) {
        this.bloges = bloges;
    }
}
