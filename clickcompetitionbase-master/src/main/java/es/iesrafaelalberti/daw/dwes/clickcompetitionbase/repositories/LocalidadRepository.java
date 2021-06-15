package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Localidad;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public interface LocalidadRepository extends CrudRepository<Localidad, Long> {

//    Localidad findLocalidadByName(String name);


    @Query("select new Localidad(l.id, l.name, sum(pl.clicks)) from Localidad l"  +
            " join Player pl on l.id = pl.localidad.id " +
            " group by l.id ORDER BY sum(pl.clicks) desc  ")

    public ArrayList<Localidad> localidadListOrder();

}
