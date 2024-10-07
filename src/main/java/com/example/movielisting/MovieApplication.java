package com.example.movielisting;

import  com.example.movielisting.service.*;
import  com.example.movielisting.model.*;
import com.example.movielisting.constants.MovieConstants;
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
                MovieConstants.DEFAULT_MOVIES.forEach(movieService::addMovie);

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
                                System.out.println("Press 4 to add a movie to favorites ");
                                System.out.println("Press 5 to remove a movie from favorites ");
                                System.out.println("Press 6 to see user details ");
                                System.out.println("Press 7 to search favorite movies ");
                                System.out.println("press 8 to Exit from application ");


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
                                           System.out.print("Enter the title of the movie to add to favorites: ");
                                           String titleToAdd = scanner.nextLine();
                                           Optional<Movie> movieToAdd = movieService.getMovieDetails(titleToAdd);
                                           movieToAdd.ifPresent(movie -> {
                                               userService.addFavoriteMovie(currentUser, movie);
                                               System.out.println(movie.getTitle() + " added to favorites.");
                                           });
                                           break;
                                       case 5:
                                           System.out.print("Enter the title of the movie to remove from favorites: ");
                                           String titleToRemove = scanner.nextLine();
                                           Optional<Movie> movieToRemove = movieService.getMovieDetails(titleToRemove);
                                           movieToRemove.ifPresent(movie -> {
                                               userService.removeFavoriteMovie(currentUser, movie);
                                               System.out.println(movie.getTitle() + " removed from favorites.");
                                           });
                                           break;
                                       case 6:
                                            userService.showUserDetails(currentUser);
                                            break;
                                       case 7:
                                            System.out.print("Enter title, cast, or category to search in favorites: ");
                                            String searchQuery = scanner.nextLine();
                                            List<Movie> foundFavoriteMovies = userService.searchFavoriteMovies(currentUser, searchQuery);
                                            if (foundFavoriteMovies.isEmpty()) {
                                                System.out.println("No favorite movies found matching your search.");
                                            } else {
                                                System.out.println("Found favorite movies:");
                                                foundFavoriteMovies.forEach(movie -> System.out.println(movie.getTitle()));
                                            }
                                            break;
                                       case 8:
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

