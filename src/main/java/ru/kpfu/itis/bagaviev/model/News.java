package ru.kpfu.itis.bagaviev.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column private String author;

    @Column private String title;

    @Column private String text;

    @Column(name = "posting_time") private Timestamp postingTime;

    @Column private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Timestamp postingTime) {
        this.postingTime = postingTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
