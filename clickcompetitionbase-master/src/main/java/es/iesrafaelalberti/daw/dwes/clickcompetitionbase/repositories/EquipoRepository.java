package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Equipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EquipoRepository extends CrudRepository<Equipo, Long> {

    @Query("select e from Equipo e where e.name = :name ")

    Equipo findEquiposByName(String name);

}
