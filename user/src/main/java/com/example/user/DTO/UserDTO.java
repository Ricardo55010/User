package com.example.user.DTO;


public class UserDTO {
    Long id;
    String name;
    Integer age;
    Integer wage;

    public UserDTO(Long id,String name, Integer age, Integer wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }
    public UserDTO(String name, Integer age, Integer wage) {
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wage=" + wage +
                '}';
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }
}