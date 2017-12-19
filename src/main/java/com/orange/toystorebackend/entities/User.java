package com.orange.toystorebackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;

    @Column(name = "username" , nullable = false)
    private String username;

    @Column(name = "email" , unique = true , nullable = false)
    private String email ;

    @Column(name = "password" , nullable = false)
    private String password ;

    @Column(name = "gender" , nullable = false)
    private String gender;

    @Column(name = "question" , nullable = false)
    private String question ;

    @Column(name = "answer" , nullable = false)
    private String answer;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<PurchaseOrder> orderList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<PurchaseOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<PurchaseOrder> orderList) {
        this.orderList = orderList;
    }
}
