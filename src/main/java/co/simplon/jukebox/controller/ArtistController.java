package co.simplon.jukebox.controller;

import co.simplon.jukebox.Artist;
import co.simplon.jukebox.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jukebox")
public class ArtistController<ArtistService> {

    @Autowired
    ArtistService service;
    @CrossOrigin
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtist(@RequestParam(value="search", defaultValue="") String search) {
        List<Artist> listArtist;
        try {
            listArtist = service.findAll(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listArtist);
    }

    @CrossOrigin
    @GetMapping("/artists/{id}")
    ResponseEntity<Artist> getArtistById(@PathVariable(value="id") long id) {
        Optional<Artist> artist = service.findById(id);
        if (artist.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artist.get());
    }
    
    @PostMapping("/artists")
    ResponseEntity<Artist> addArtist(@Valid @RequestBody Artist artist){
        return ResponseEntity.ok().body(service.insert(artist));
    }

    @CrossOrigin
    @PutMapping("/artists/{id}")
    ResponseEntity<Artist> updateArtiste(@PathVariable(value="id") long id, @Valid @RequestBody Artist artist){
        Artist updatedArtiste = service.update(id, artist);
        if(updatedArtiste == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(updatedArtiste);
    }

    @CrossOrigin
    @DeleteMapping("/artists/{id}")
    ResponseEntity<Artist> deleteArtist(@PathVariable(value="id") long id){
        Optional<Artist> artist = service.findById(id);
        if(artist.isEmpty())
            return ResponseEntity.notFound().build();
        service.delete(artist.get().getId());
        return ResponseEntity.accepted().build();
    }
}