package com.substring.core;

import com.substring.core.concepts.Car;
import com.substring.core.concepts.Engine;
import com.substring.core.concepts.Fuel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//        Fuel fuel1=new Fuel();
//        Engine bmwEngine1=new Engine(fuel1);
//        Car carSp321=new Car(bmwEngine1);
//        carSp321.startCar();
        //ki bhaiya mujhe chahie fuel object


        // container
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Fuel fuel = context.getBean("fuel", Fuel.class);
        fuel.use();


    }
}
