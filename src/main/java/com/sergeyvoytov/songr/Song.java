package com.sergeyvoytov.songr;

import javax.persistence.*;


@Entity

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album album;

    public String title;
    public int length;
    public int trackNumber;

    public Song() {

    }

    public Song(String title, int length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public String toString() {
        return String.format("Title of the song : %s , length of the song is %d seconds and track number is : %d", title, length, trackNumber);
    }
}
