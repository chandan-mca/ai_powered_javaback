package com.substring.core.concepts;

public class Engine {

    Fuel fuel;

    public Engine(Fuel fuel) {
        this.fuel = fuel;
    }

    void startEngine(){
        fuel.use();
        System.out.println("Engine started...");
    }
}
