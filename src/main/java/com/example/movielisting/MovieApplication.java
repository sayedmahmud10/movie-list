package com.example.movielisting;

import  com.example.movielisting.service.*;
import  com.example.movielisting.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MovieApplication{

    private User currentUser;
    private List<User> users = new ArrayList<>();
    private UserService userService=  new UserService();
    private MovieService movieService=  new MovieService();
    private boolean programRunner =true ;

        public static void main(String[] args) {
            new MovieApplication().run();
        }

        public void run(){
                Scanner scanner = new Scanner(System.in);
                movieService.addMovie(new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", "2010", 160000000));
                movieService.addMovie(new Movie("The Dark Knight", "Christian Bale", "Action", "2008", 185000000));
                movieService.addMovie(new Movie("Interstellar", "Matthew McConaughey", "Sci-Fi", "2014", 165000000));
                movieService.addMovie(new Movie("Titanic", "Leonardo DiCaprio", "Romance", "1997", 200000000));

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
                                System.out.println("press 1 to log out ");
                                System.out.println("Press 2 to search for movies ");
                                System.out.println("Press 3 to see details of movie ");
                                System.out.println("press 4 to Exit from application ");

                                int choice = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice) {
                                       case 1:
                                            currentUser = null;
                                            System.out.println("Logged out.");
                                            break;
                                       case 2:
                                           System.out.print("Enter title, cast, or category to search for movies: ");
                                           String query = scanner.nextLine();
                                           List<Movie> foundMovies = movieService.searchMovies(query);
                                           if (foundMovies.isEmpty()) {
                                               System.out.println("No movies found matching your search.");
                                           } else {
                                               System.out.println("Found movies:");
                                               foundMovies.forEach(movie -> System.out.println(movie.getTitle()));
                                           }
                                           System.out.println();
                                           break;
                                       case 3:
                                          System.out.print("Enter title to see the details ");
                                          String queryDetails = scanner.nextLine();
                                          Optional<Movie> optionalMovie = movieService.getMovieDetails(queryDetails);
                                          if (optionalMovie.isPresent()) {
                                                Movie movie = optionalMovie.get();
                                                System.out.println("Details : \n " + movie.toString());
                                          }
                                          else{                                                                                            System.out.println("No movies found matching your search.");
                                            System.out.println("No movies found matching your search.\n");
                                          }

                                          break;
                                       case 4:
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

