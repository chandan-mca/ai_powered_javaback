package com.substring;

import com.substring.config.DbConfig;
import com.substring.models.User;
import com.substring.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        var context = new AnnotationConfigApplicationContext(DbConfig.class);

        var userService = context.getBean(UserService.class);

//        var user1=new User(0,"Aditya Pawar","123654");
//        userService.saveUser(user1);

        String choice = "N";

        do {

            IO.println("Press 1 to add user");
            IO.println("Press 2 to show all users: ");
            int inputChoice = Integer.parseInt(IO.readln("Your choice:"));


            switch (inputChoice) {


                case 1 -> {
                    String name = IO.readln("Enter your name: ");
                    String phone = IO.readln("Enter your phone: ");
                    var user1 = new User(0, name, phone);
                    userService.saveUser(user1);
                }

                case 2 -> {
                    userService.getUsers().stream().forEach(user -> {

                        IO.println(user.getId() + " : " + user.getName() + " : " + user.getPhone());
                    });
                    IO.println("__________________________");
                }

                default -> {
                    IO.println("Invalid choice!");
                }

            }


            choice = IO.readln("Do you want to continue? [Y/N]");


        } while (choice.equalsIgnoreCase("Y"));

        IO.println("Thank you for using app");
//        IO.println("see you soon !!");

        JOptionPane.showMessageDialog(null,"See you soon");
    }
}
