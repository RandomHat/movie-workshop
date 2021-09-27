package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file
    private static final MovieDataRepository movieDataRepository = new MovieDataRepository(); //SingletonPattern
    private final List<Movie> movies;
    private MovieDataRepository(){
        this.movies = loadMovies("resources/imdb-data.csv");
    }

    public static MovieDataRepository getMovieDataRepository() {
        return movieDataRepository;
    }

    public List<Movie> getMovies(){
        return this.movies;
    }

    private ArrayList<Movie> loadMovies(String path){
        File file = new File(path);
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                movies.add(parseDataString(sc.nextLine()));
            }
        } catch (FileNotFoundException err){
            System.out.println("File not found =" + err);
        }
        return movies;
    }

    private Movie parseDataString(String currentLine){

        // Split and directly parse
        String[] split = currentLine.trim().split(";");
        int year = Integer.parseInt(split[0]);
        int length = Integer.parseInt(split[1]);
        String title = split[2];
        String subject = split[3];
        int popularity = Integer.parseInt(split[4]);
        boolean awards = split[5].equals("Yes");

        // Initialize and return object
        Movie mov = new Movie(year, length, title, subject, popularity, awards);
        return mov;
    }

    public static void main(String[] args) {
        MovieDataRepository repo = MovieDataRepository.getMovieDataRepository();
        for (Movie movie : repo.getMovies()){
            System.out.println(movie);
        }
    }
}
