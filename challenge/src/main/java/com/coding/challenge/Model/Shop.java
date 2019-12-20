package com.coding.challenge.Model;

import com.coding.challenge.Model.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Shop implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_seq")
    @SequenceGenerator(name = "shop_seq", sequenceName = "shop_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "dislikedId")
    @JsonBackReference
    private DislikedShops dislikedshops;

    @ManyToOne
    @JoinColumn(name = "likedId")
    @JsonBackReference
    private LikedShops likedshops;

   public Shop(){

   }

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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
