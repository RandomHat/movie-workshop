package com.example.movieworkshop.controllers;

import com.example.movieworkshop.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    //Controller methods
    @GetMapping("/")
    public String index(){

        String url = "<br><a href=/";
        String getFirst = url+"getFirst>Get the first movie</a>";
        String getRandom =  url + "getRandom>Get a random movie</a>";
        String getTen = url + "getTenSortByPopularity>Get the ten most popular</a>";
        String howMany = url + "howManyWonAnAward>See how many movies won an award</a>";
        String filter = url + "filter>Filter movies by letter and amount</a>";
        String longest = url + "longest>Compare average runtime of genres</a>";

        return "<h1> Hello World welcome to my application </h1>"+ getFirst + getRandom + getTen +
                howMany + filter + longest;
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
    public String filterLetterAmount(@RequestParam(defaultValue = "a") char type, @RequestParam(defaultValue = "2") int amount){
        return movieService.filterLetterAmount(type, amount);
    }

    @GetMapping("/longest")
    public String filterLongestByGenre(@RequestParam(defaultValue = "drama") String g1, @RequestParam(defaultValue = "action") String g2){
        return movieService.longestByGenre(g1,g2);
    }
}
