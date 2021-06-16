package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.controllers;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Equipo;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Localidad;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.EquipoRepository;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
@RestController
public class EquipoController {

    @Autowired
   EquipoRepository equipoRepository;


    @GetMapping(value = "/equipos")
    public ResponseEntity<Object> listEquipo() {
        return new ResponseEntity<>(equipoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/equipo/{id}")
    public ResponseEntity<Object> equipoDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(equipoRepository.findById(id).orElseThrow(EntityNotFoundException::new),
                HttpStatus.OK);
    }

    @PostMapping("/equipo/add")
    public ResponseEntity<?> equipoAdd(@RequestBody Equipo nuevoequipo) {
        equipoRepository.save(nuevoequipo);
        return new ResponseEntity<>(nuevoequipo, HttpStatus.OK);
    }

    @PutMapping("/equipo/{id}")
    public ResponseEntity<?> equipoUpdate(@PathVariable("id") Long id,
                                          @RequestBody Equipo nuevoequipo) {
        equipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        equipoRepository.save(nuevoequipo);
        return new ResponseEntity<>(nuevoequipo, HttpStatus.OK);
    }


    @DeleteMapping("/equipo/{id}")
    public ResponseEntity<?> equipoDelete(@PathVariable("id") Long id) {
        Equipo oldEquipo = equipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        equipoRepository.delete(oldEquipo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/equipo/{name}/players")
    public ResponseEntity<Object> equipoListOrder(@PathVariable("name") String name){
        return new ResponseEntity<>(equipoRepository.findEquiposByName(name), HttpStatus.OK);
    }

}
