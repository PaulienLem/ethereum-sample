package com.example.ethereum.models;

import javax.persistence.*;

@Table
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String username;

    @Column()
    private String password;

    @Column()
    private String file;

    public Account(String username, String password, String file) {
        this.username = username;
        this.password = password;
        this.file = file;
    }

    public Account(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPasword(String pasword) {
        this.password = pasword;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
