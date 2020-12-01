package co.simplon.jukebox.controller;

import co.simplon.jukebox.Artist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jukebox")
public class ArtistController {

    @CrossOrigin
    @GetMapping("/artist/hello")
    ResponseEntity<Artist> getArtistToto() {
        Artist hello = new Artist();
        hello.setName("Hello");
        hello.setBio("Comment allez-vous ?");
        hello.setFanNumber(100);
        return ResponseEntity.ok().body(hello);
    }
}