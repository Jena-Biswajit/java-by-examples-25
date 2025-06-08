package com.example.arraylist.models;

import java.util.Comparator;

public class IdComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o2.id.compareTo(o1.id);
    }
}
