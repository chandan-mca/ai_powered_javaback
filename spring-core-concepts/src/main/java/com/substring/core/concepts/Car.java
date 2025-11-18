package com.substring.core.concepts;

public class Car
{

    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar(){
        //engine start karna hai apan ko
        System.out.println("car is starting..");
        engine.startEngine();
        System.out.println("card started..");

    }
}
