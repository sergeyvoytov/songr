package com.sergeyvoytov.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    // our controller should have routes
    // must be a method that returns a string

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    // The syntax for getting getting a query param is just to add it as a function parameter
    public String getHome(Model m) {
        System.out.println("potato");
        return "home";
    }

    @PostMapping("/albums")
    // whatever is in my form as an input can be a parameter here
    public RedirectView posAlbums(String title, String artist, Integer songCount, Integer length, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);

        return new RedirectView("/albums");

    }

    @GetMapping("/albums")
    public String getAlbums(Model m) {
//        Album[] albums = new Album[]{new Album("Sing for the second", "Duke", 10, 180, "https://via.placeholder.com/150"),
//                new Album("Sing for the moment", "Duke", 10, 180, "https://via.placeholder.com/150"),
//                new Album("Number 1", "Prince", 7, 80, "https://via.placeholder.com/150"),
//                new Album("Test4", "Nuke", 2, 124, "https://via.placeholder.com/150")};
//List<Albums> albums = albumRepository

        List<Album> albums = albumRepository.findAll();

        m.addAttribute("albumList", albums);
        return "albums";
    }

    @GetMapping("/hello")
    public String hello(Model m) {
        return "hello";
    }

    @GetMapping("/capitalize/{capitalize}")
    public String capitilize(@PathVariable String capitalize, Model m) {
        System.out.println((capitalize.toUpperCase()));
        m.addAttribute("tomato", capitalize.toUpperCase());
        return "capitalize";
    }
}