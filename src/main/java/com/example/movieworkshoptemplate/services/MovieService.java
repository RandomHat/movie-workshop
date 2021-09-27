package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.util.List;
import java.util.Random;

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
}
