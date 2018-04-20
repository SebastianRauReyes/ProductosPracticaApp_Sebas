package com.rau.sebastian.productospracticaapp_sebas.models;


import com.orm.dsl.Table;

@Table
public class User {

    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;

    public  User(){
    }

    public User(String username, String fullname, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
