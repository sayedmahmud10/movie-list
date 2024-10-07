# movie-list


# Project Details:

    Java Version: 17.0.12
    Build Tool: Maven (for dependency management and project build {version 3.6.3})
    Generated JAR: After building, the .jar file is located in the target directory.
    Testing Framework: JUnit 5 (JUnit Jupiter)

# Key Features:

    Allows users to register/log in with an email (no authentication required).
    Search for movies by title, cast, or category, with results returned in ascending order of movie titles.
    View detailed information for any movie, including title, cast, category, release date, and budget.
    Add or remove movies from your favorites list.
    View personal details and the list of movies you've added to favorites.
    Search for movies specifically in your favorites list.

# Movie Storage:

    Default movie data is stored in the MovieConstants class, which is located at: src/main/java/com/example/movielisting/constants/MovieConstants.java
# Running the Application
    You can run the application with Maven using the following command:
        mvn exec:java
    If you'd like to run the application without Maven:
        java -jar target/MovieListingApp-1.0-SNAPSHOT.jar
 All unit tests are written using JUnit 5 and can be executed via Maven using the command:
    mvn test