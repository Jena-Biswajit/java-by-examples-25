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
