package com.sergeyvoytov.songr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTest {
    Album testAlbum;

    @BeforeEach
    public void setUp() throws Exception {
        testAlbum = new Album("TestName", "TestArtist", 1, 11, "example.com");
    }

    @Test
    public void getTitle() {
        assertEquals("TestName", testAlbum.getTitle());
    }

    @Test
    public void getArtist() {
        assertEquals("TestArtist", testAlbum.getArtist());
    }

    @Test
    public void getSongCount() {
        assertEquals(1, testAlbum.getSongCount());
    }

    @Test
    public void getLength() {
        assertEquals(1, testAlbum.getLength());
    }

    @Test
    public void getImageUrl() {
        assertEquals("example.com", testAlbum.getImageUrl());
    }

    @Test
    public void setTitle() {
        testAlbum.setTitle("New Title");
        assertEquals("title is: New Title and artist is : TestArtist and amount of songs are: 1 and length is : 11", testAlbum.toString());
    }

    @Test
    public void setArtist() {
        testAlbum.setArtist("New Artist");
        assertEquals("title is: TestName and artist is : New Artist and amount of songs are: 1 and length is : 11", testAlbum.toString());
    }

    @Test
    public void setSongCount() {

        testAlbum.setSongCount(10000);
        assertEquals("title is: TestName and artist is : TestArtist and amount of songs are: 10000 and length is : 11", testAlbum.toString());
    }

    @Test
    public void setLength() {
        testAlbum.setLength(909090);
        assertEquals("title is: TestName and artist is : TestArtist and amount of songs are: 1 and length is : 909090", testAlbum.toString());
    }
}

