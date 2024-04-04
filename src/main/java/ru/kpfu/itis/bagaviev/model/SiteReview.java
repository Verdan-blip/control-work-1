package ru.kpfu.itis.bagaviev.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "site_reviews")
public class SiteReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column private Date date;

    @Column private String text;

    @Column private Short rate;

    @Column(name = "star_rate") private Short starRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }

    public Short getStarRate() {
        return starRate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStarRate(Short starRate) {
        this.starRate = starRate;
    }
}
