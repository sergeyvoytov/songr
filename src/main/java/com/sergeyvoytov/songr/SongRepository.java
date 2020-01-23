package com.sergeyvoytov.songr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findSongByAlbumId(long albumId);
}
