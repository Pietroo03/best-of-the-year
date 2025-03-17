package org.exercise.java.spring.best_of_the_year.controllers;

import java.util.List;

import org.exercise.java.spring.best_of_the_year.BestOfTheYearApplication;
import org.exercise.java.spring.best_of_the_year.classes.Movie;
import org.exercise.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

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
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();

        model.addAttribute("movies", movies);
        model.addAttribute("currentPage", "/movies");
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();

        model.addAttribute("songs", songs);
        model.addAttribute("currentPage", "/songs");

        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieById(Model model, @PathVariable("id") int id) {

        List<Movie> movies = getBestMovies();
        Movie foundMovie = null;

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                foundMovie = movie;
                break;
            }
        }

        model.addAttribute("movie", foundMovie);
        model.addAttribute("id", id);
        return "singleMovie";
    }

    @GetMapping("/songs/{id}")
    public String songById(Model model, @PathVariable("id") int id) {

        List<Song> songs = getBestSongs();
        Song foundSong = null;

        for (Song song : songs) {
            if (song.getId() == id) {
                foundSong = song;
                break;
            }
        }

        model.addAttribute("song", foundSong);
        model.addAttribute("id", id);
        return "singleSong";
    }

}
