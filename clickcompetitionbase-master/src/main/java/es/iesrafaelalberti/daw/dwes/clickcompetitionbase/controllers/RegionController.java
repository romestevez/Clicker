package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.controllers;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Region;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/region/{id}")
    public ResponseEntity<Object> regionDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(regionRepository.findById(id).orElseThrow(EntityNotFoundException::new),
                HttpStatus.OK);
    }

    @PostMapping("/region/add")
    public ResponseEntity<?> regionAdd(@RequestBody Region nuevaRegion) {
        regionRepository.save(nuevaRegion);
        return new ResponseEntity<>(nuevaRegion, HttpStatus.OK);
    }

    @PutMapping("/region/{id}")
    public ResponseEntity<?> regionUpdate(@PathVariable("id") Long id,
                                             @RequestBody Region nuevaRegion) {
        regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        regionRepository.save(nuevaRegion);
        return new ResponseEntity<>(nuevaRegion, HttpStatus.OK);
    }


    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> regionDelete(@PathVariable("id") Long id) {
        Region oldRegion = regionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        regionRepository.delete(oldRegion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/region/clicks")
    public ResponseEntity<Object> regionListOrder(){
        return new ResponseEntity<>(regionRepository.regionListOrder(), HttpStatus.OK);
    }
}
