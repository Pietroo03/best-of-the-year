package org.exercise.java.spring.best_of_the_year.controllers;

import java.util.List;

import org.exercise.java.spring.best_of_the_year.BestOfTheYearApplication;
import org.exercise.java.spring.best_of_the_year.classes.Movie;
import org.exercise.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BestOfTheYearApplication bestOfTheYearApplication;

    HomeController(BestOfTheYearApplication bestOfTheYearApplication) {
        this.bestOfTheYearApplication = bestOfTheYearApplication;
    }

    @GetMapping("/")
    public String home(@RequestParam(name = "name") String name, Model model) {

        model.addAttribute("name", name);
        return "home";
    }

    private List<Movie> getBestMovies() {
        return List.of(
                new Movie(1, "Il Padrino"),
                new Movie(2, "Harry Potter e la Pietra FIlosofale"),
                new Movie(3, "Iron Man"));
    }

    private List<Song> getBestSongs() {
        return List.of(
                new Song(1, "Allenamento 3"),
                new Song(2, "Gli occhi della tigre"),
                new Song(3, "Il pescatore"));
    }

    @GetMapping("/movies")
    public String Movies(Model model) {
        List<Movie> movies = getBestMovies();

        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs")
    public String Songs(Model model) {
        List<Song> songs = getBestSongs();

        model.addAttribute("songs", songs);
        return "songs";
    }

}
