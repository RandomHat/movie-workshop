package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

public class MovieService {
    MovieDataRepository repo = MovieDataRepository.getMovieDataRepository();

    //Services called from controllers that returns what the client requests
    public String getFirstServ(){
        return repo.getMovies().get(0).toString();
    }
}
