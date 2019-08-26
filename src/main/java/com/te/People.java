package com.te;

import java.io.Serializable;

public class People implements Serializable {
    public String name;
    public int age;
    public Object o;

    public People(){

    }
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
