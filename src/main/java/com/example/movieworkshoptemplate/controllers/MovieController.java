package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application";
    }

    @GetMapping("/getFirst")
    public String getFirst(){
        return movieService.getFirstServ();
    }

    @GetMapping("/getRandom")
    public String getRandom(){
        return movieService.getRandom();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return movieService.getTenByPop();
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward(){
        return movieService.wonAwards();
    }

    @GetMapping("/filter")
    public String filterLetterAmount(@RequestParam char type, int amount){
        return movieService.filterLetterAmount(type, amount);
    }

    @GetMapping("/longest")
    public String filterLongestByGenre(@RequestParam String g1, String g2){
        return movieService.longestByGenre(g1,g2);
    }
}
