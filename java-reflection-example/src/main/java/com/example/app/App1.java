package com.example.app;


// crete an object of class using getClass()
public class App1 {
    public static void main(String[] args) {
        Dog animal = new Dog();
//        animal.display();
//        animal.makeSound();

        // achieve the same using .class method
        Class object = Dog.class;
        System.out.println(object.getName());

        // get details of superclass . here the object is referring to Dog object
        // hence it will return the superclass of Dog class
       Class superClass = object.getSuperclass();
       System.out.println(superClass);


    }
}
class Animal{
    public void display(){
        System.out.println("I am a dog ");
    }
}
class Dog extends Animal{
    public void makeSound(){
        System.out.println("bark bark");
    }
}
