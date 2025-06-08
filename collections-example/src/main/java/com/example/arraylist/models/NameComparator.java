package com.example.arraylist.app;

import com.example.arraylist.models.Employee;
import com.example.arraylist.models.Student;

import java.util.Comparator;

public class App6 implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2){

        return o1.name.compareTo(o2.name);
    }

}
