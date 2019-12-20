package com.coding.challenge.Model;

import com.coding.challenge.Model.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class User implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String numtel;
    private boolean isValid;
    private String status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<LikedShops> likedshops;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<DislikedShops> dislikedshops;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String status){
          this.status=status;
    }
    public User(){}


    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User(String firstname, String lastname, String numtel,String email,  String adress, String password){

        super();
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.numtel=numtel;


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
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the numtel
     */
    public String getNumtel() {
        return numtel;
    }

    /**
     * @param numtel the numtel to set
     */
    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }




    /**
     * @return String return the username
     */
    public String getUsername() {
        return this.email;
    }




    /**
     * @return boolean return the isValid
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }


    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Set<Role> return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
