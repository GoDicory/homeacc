package com.homeacc.repository;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_login")
    private String userLogin;
    private LocalDate data;
    private String score;

    private String categories;
    @Column(name = "sub_categories")
    private String subCategories;
    private BigDecimal summa;
    private String comments;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Transient
    private Long categoryId;

    public Transactions() {

    }
    public Transactions(Long id, String userLogin, LocalDate data, String score, String categories, String subCategories, BigDecimal summa, String comments) {
        this.id = id;
        this.userLogin = userLogin;
        this.data = data;
        this.score = score;
        this.categories = categories;
        this.subCategories = subCategories;
        this.summa = summa;
        this.comments = comments;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getUserLogin() {return userLogin;}
    public void setUserLogin(String userLogin) {this.userLogin = userLogin;}
    public LocalDate getData() {return data;}
    public void setData(LocalDate data) {this.data = data;}
    public String getScore() {return score;}
    public void setScore(String score) {this.score = score;}
    public String getCategories() {return categories;}
    public void setCategories(String categories) {this.categories = categories;}
    public String getSubCategories() {return subCategories;}
    public void setSubCategories(String subCategories) {this.subCategories = subCategories;}
    public BigDecimal getSumma() {return summa;}
    public void setSumma(BigDecimal summa) {this.summa = summa;}
    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}
}
