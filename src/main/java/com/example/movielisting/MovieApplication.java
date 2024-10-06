package com.example.movielisting;

import  com.example.movielisting.service.UserService;
import  com.example.movielisting.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MovieApplication{

    private User currentUser;
    private List<User> users = new ArrayList<>();
    private UserService userService=  new UserService();
    private boolean programRunner =true ;

        public static void main(String[] args) {
            new MovieApplication().run();
        }

        public void run(){
                Scanner scanner = new Scanner(System.in);
                 while (programRunner) {
                            if (currentUser == null) {
                                System.out.print("Enter your email to register/log in: ");
                                String email = scanner.nextLine();

                                // Check if the user is registered, if not  then registering the user otherwise logging in
                                Optional<User> optionalUser = userService.login(users, email);
                                if (optionalUser.isPresent()) {
                                    currentUser = optionalUser.get();
                                    System.out.println("Logged in user: " + currentUser.getEmail());
                                } else {
                                    currentUser = userService.registerUser(email);
                                    users.add(currentUser);
                                    System.out.println("Registered user: " + currentUser.getEmail());
                                }
                            }
                            else{
                                System.out.print("press 1 to log out ");
                                System.out.print("press 2 to Exit from application ");

                                int choice = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice) {
                                       case 1:
                                            currentUser = null;
                                            System.out.println("Logged out.");
                                            break;
                                       case 2:
                                            programRunner = false;
                                            System.out.println("Exiting the application. Goodbye!");
                                            break;
                                       default:
                                            System.out.println("Invalid choice. Please try again.");

                                }



                            }

                        }

                        scanner.close();
        }

}

