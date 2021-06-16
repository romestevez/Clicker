package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.controllers;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Localidad;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class LocalidadController {

    @Autowired
    LocalidadRepository localidadRepository;


    @GetMapping(value = "/localidades")
    public ResponseEntity<Object> listLocalidad() {
        return new ResponseEntity<>(localidadRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/localidad/{id}")
        public ResponseEntity<Object> localidadDetail(@PathVariable("id") Long id) {
            return new ResponseEntity<>(localidadRepository.findById(id).orElseThrow(EntityNotFoundException::new),
                    HttpStatus.OK);
    }

    @PostMapping("/localidad/add")
    public ResponseEntity<?> localidadAdd(@RequestBody Localidad nuevaLocalidad) {
        localidadRepository.save(nuevaLocalidad);
        return new ResponseEntity<>(nuevaLocalidad, HttpStatus.OK);
    }

    @PutMapping("/localidad/{id}")
    public ResponseEntity<?> localidadUpdate(@PathVariable("id") Long id,
                                          @RequestBody Localidad nuevaLocalidad) {
        localidadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        localidadRepository.save(nuevaLocalidad);
        return new ResponseEntity<>(nuevaLocalidad, HttpStatus.OK);
    }


    @DeleteMapping("/localidad/{id}")
    public ResponseEntity<?> localidadDelete(@PathVariable("id") Long id) {
        Localidad oldLocalidad = localidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        localidadRepository.delete(oldLocalidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/localidad/clicks")
    public ResponseEntity<Object> localidadListOrder(){
        return new ResponseEntity<>(localidadRepository.localidadListOrder(), HttpStatus.OK);
    }

}