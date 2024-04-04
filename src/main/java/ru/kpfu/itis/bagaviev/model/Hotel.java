package ru.kpfu.itis.bagaviev.model;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column private String name;

    @Column private String location;

    @Column private String description;

    @Column(length = 2048) private String image;

    @Column private Short rate;

    @Column(name = "price_per_night") private Integer pricePerNight;

    @Column(name = "star_rating") private Short starRating;

    @Column private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Short getStarRating() {
        return starRating;
    }

    public void setStarRating(Short starRating) {
        this.starRating = starRating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
