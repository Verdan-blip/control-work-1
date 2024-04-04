package ru.kpfu.itis.bagaviev.model;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user1_id")
    private User user1;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user2_id")
    private User user2;

    @Column private Short status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }


    public User getUser2() {
        return user2;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
