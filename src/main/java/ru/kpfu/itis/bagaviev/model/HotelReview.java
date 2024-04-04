package ru.kpfu.itis.bagaviev.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "hotel_reviews")
public class HotelReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinColumn(name = "hotel_id")
    private Set<Hotel> hotels;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private Set<User> users;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Date date;

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
