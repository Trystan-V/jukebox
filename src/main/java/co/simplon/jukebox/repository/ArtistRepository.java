package co.simplon.jukebox.repository;

import co.simplon.jukebox.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    public List<Artist> findByNameContaining(String name);
}


