package com.upgrad.dcf.model;

import javax.persistence.*;


@Entity
@Table(name = "userinfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "age",unique = true)
    private String age;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "pnum")
    private String pnum;




    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return pnum;
    }

    public void setPhone(String pnum) {
        this.pnum = pnum;
    }
}

