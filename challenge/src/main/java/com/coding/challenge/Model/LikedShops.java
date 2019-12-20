package com.coding.challenge.Model;

import com.coding.challenge.Model.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class LikedShops implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liked_seq")
    @SequenceGenerator(name = "liked_seq", sequenceName = "liked_seq", allocationSize = 1)
    private Long id;


    @OneToMany(mappedBy = "likedshops", cascade = CascadeType.ALL)
    private Set<Shop> shop;


    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Set<Shop> return the shop
     */
    public Set<Shop> getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(Set<Shop> shop) {
        this.shop = shop;
    }


    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
