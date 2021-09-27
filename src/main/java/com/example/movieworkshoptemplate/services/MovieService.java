package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.util.*;

public class MovieService {
    MovieDataRepository repo = MovieDataRepository.getMovieDataRepository();

    //Services called from controllers that returns what the client requests
    public String getFirstServ(){
        return repo.getMovies().get(0).toString();
    }

    public String getRandom(){
        List<Movie> list = repo.getMovies();
        Random random = new Random();
        int legalInt = random.nextInt(list.size());
        return list.get(legalInt).toString();
    }

    public String getTenByPop(){
        List<Movie> movies = repo.getMovies();
        String sortedMovies = "";
        // Wanted to do the sort using Collections, but implementing Comparable seemed wrong since we're going to want to compare multiple different fields.
        // This is an Anonymous Inner Class? that implements the comparator interface and overides the compare method.
        // Sort in descending order high -> low, reversing the objects would sort ascending.
        Comparator<Movie> byLength = new Comparator<Movie>(){
            @Override
            public int compare(Movie o1, Movie o2){
                return o2.getPopularity() - o1.getPopularity();
            }
        };

        Collections.sort(movies, byLength);

        //Take the first 10 movies in the sorted array and make a string.
        for (int i = 0; i<10; i++){
            sortedMovies = sortedMovies.concat(movies.get(i).toString() + "\n");
        }
        return sortedMovies;
    }

    public String wonAwards(){
        List<Movie> movies = repo.getMovies();
        int count = 0;

        for (Movie mov: movies) {
            if (mov.hasAwards()){
                count++;
            }
        }

        return Integer.toString(count);
    }

    public String filterLetterAmount(char letter, int amount){
        List<Movie> movies = repo.getMovies();
        String filtered = "";

        for (Movie mov : movies) {
            if (countLetters(mov.getTitle(), letter, amount)) {
                filtered = filtered.concat(mov.toString() + "\n");
            }
        }
        return filtered;
    }

    public boolean countLetters(String string, char letter, int amount){
        char[] arr = string.toCharArray();
        int count = 0;

        for (char ch : arr){
            if (ch == letter){
                count++;
            }
        }

        return amount == count;
    }

    public String longestByGenre(String g1, String g2){
        List<Movie> movies = repo.getMovies();
        String winner = "Aaaand the Winner is: ";
        double g1Avg, g2Avg;
        int g1Sum, g1Count, g2Sum, g2Count;
        g1Sum = g1Count = g2Sum = g2Count = 0;

        for (Movie mov : movies) {
            if (mov.getSubject().toLowerCase(Locale.ROOT).equals(g1.toLowerCase(Locale.ROOT))){
                g1Sum += mov.getLength();
                g1Count++;
            }
            if (mov.getSubject().toLowerCase(Locale.ROOT).equals(g2.toLowerCase(Locale.ROOT))){
                g2Sum += mov.getLength();
                g2Count++;
            }
        }

        g1Avg = (double) g1Sum/g1Count;
        g2Avg = (double) g2Sum/g2Count;

        String g1Res = "the Genre " + g1 +" has and average length of: ";
        g1Res += String.format("%.2f", g1Avg);
        String g2Res = "the Genre " + g2 +" has and average length of: ";
        g2Res += String.format("%.2f", g2Avg);

        if (g1Avg > g2Avg){
            winner += g1;
        } else if (g1Avg == g2Avg){
            winner += "It's a TIE";
        } else {
            winner += g2;
        }

        return g1Res + "\n" + g2Res + "\n\n" + winner;
    }

}
