package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.controllers;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Pais;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Region;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.PaisRepository;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class PaisCrontroller {
    @Autowired
    PaisRepository paisRepository;

    @GetMapping("/pais/{id}")
    public ResponseEntity<Object> paisDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(paisRepository.findById(id).orElseThrow(EntityNotFoundException::new),
                HttpStatus.OK);
    }

    @PostMapping("/pais/add")
    public ResponseEntity<?> paisAdd(@RequestBody Pais nuevoPais) {
        paisRepository.save(nuevoPais);
        return new ResponseEntity<>(nuevoPais, HttpStatus.OK);
    }

    @PutMapping("/pais/{id}")
    public ResponseEntity<?> paisUpdate(@PathVariable("id") Long id,
                                          @RequestBody Pais nuevoPais) {
        paisRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        paisRepository.save(nuevoPais);
        return new ResponseEntity<>(nuevoPais, HttpStatus.OK);
    }


    @DeleteMapping("/pais/{id}")
    public ResponseEntity<?> paisDelete(@PathVariable("id") Long id) {
        Pais oldPais = paisRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        paisRepository.delete(oldPais);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/pais/clicks")
    public ResponseEntity<Object> PaisLisOrder(){
        return new ResponseEntity<>(paisRepository.PaisLisOrder(), HttpStatus.OK);
    }
}
