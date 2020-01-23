package com.sergeyvoytov.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    // our controller should have routes
    // must be a method that returns a string

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

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


    @GetMapping("/albums/{id}")
    public String albumDetail(@PathVariable long id, Model m) {

        Album album = albumRepository.findById(id).get();

        m.addAttribute("album", album);

        List<Song> songs = songRepository.findSongByAlbumId(id);

        m.addAttribute("songs", songs);

        return "detail";
    }

    @PostMapping("/song")
    public RedirectView addSong(long id, String title, int length, int trackNumber) {
        // find the right album
        Album myAlbum = albumRepository.getOne(id);
        // make a new song with the values from a form
        Song newSong = new Song(title, length, trackNumber);

        // add a album to the song
        newSong.album = myAlbum;
        //save the song
        songRepository.save(newSong);
        songRepository.findById(id);
        // redirect them
        return new RedirectView("/albums/" + id);
    }

    @GetMapping("/allsongs")
    public String allSongs(Model m) {

        List<Song> allsongs = songRepository.findAll();
        m.addAttribute("allsongs", allsongs);
        return "allsongs";
    }
}