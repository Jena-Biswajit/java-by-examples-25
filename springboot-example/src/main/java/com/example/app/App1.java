package com.example.app;
// loosely coupling
// ex;1
class Subject{
    Topic t1 ;
    public void startReading(){
        t1 = new Topic();
        t1.reading();
    }
}
class Topic{
    public void reading(){
        System.out.println("reading topics ");
    }
}

// ex-2
class PetrolEngine{
    public void start(){
        System.out.println("petrol engine started");
    }
}

class DieselEngine{
    public void start(){
        System.out.println("diesel engine started");
    }
}
class Car{
    PetrolEngine petrolEngine = new PetrolEngine();
    DieselEngine dieselEngine = new DieselEngine();
    public void drive(){
        System.out.println("car is driving");
        petrolEngine.start();
        dieselEngine.start();
    }
}

public class App1 {
    public static void main(String[] args) {
         Subject s = new Subject();
         s.startReading();

         Car p = new Car();
         p.drive();
    }
}
