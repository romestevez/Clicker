package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Pais;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PaisRepository extends CrudRepository<Pais, Long> {

    @Query("SELECT new Pais(p.id , p.name, SUM(pl.clicks)) " +
            "from Pais p " +
            "JOIN Region r ON p.id = r.pais.id " +
            "JOIN Localidad l ON r.id = l.region.id " +
            "JOIN  Player pl  ON l.id = pl.localidad.id " +
            "GROUP BY p.id ORDER BY SUM(pl.clicks) DESC ")

    public ArrayList<Pais> PaisLisOrder();
}
