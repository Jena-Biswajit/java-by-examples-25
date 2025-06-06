package com.example.arraylist.models;

public class Employee {
    public int id ;
    public String name ;
    public String city ;

    public Employee(int id , String name , String city ){
        this.id = id ;
        this.name = name ;
        this.city = city ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
