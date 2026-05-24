package com.homeacc.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "cat_sab_block")
public class CatSab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CatSab() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "user_login")
    private String userLogin;
    @Column(name = "category")
    private String category;
    @Column(name = "comments")
    private String comments;

    public CatSab(Long id, String userLogin, String category, String comments) {
        this.id = id;
        this.userLogin = userLogin;
        this.category = category;
        this.comments = comments;
    }

}
