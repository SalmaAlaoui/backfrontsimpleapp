package com.coding.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.coding.challenge.Model.User;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity

@Table(name = "role")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    /**
     * @return Long return the roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return Set<User> return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
