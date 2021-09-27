package com.example.movieworkshoptemplate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application";
    }

    @GetMapping("/getFirst")
    public String getFirst(){
        return "temp";
    }

    @GetMapping("/getRandom")
    public String getRandom(){
        return "temp";
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return "temp";
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward(){
        return "temp";
    }

    @GetMapping("/filter")
    public String filterBy(@RequestParam char letter, int amount){
        return "temp";
    }

}
