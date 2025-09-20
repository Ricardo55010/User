package com.example.user.Models;

import jakarta.persistence.*;

@Entity
@Table(name="User")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    Long id;
    @Column(name="name")
    String name;
    @Column(name="age")
    Integer age;
    @Column(name="wage")
    Integer wage;

    public User(String name, Integer age, Integer wage) {
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }
}