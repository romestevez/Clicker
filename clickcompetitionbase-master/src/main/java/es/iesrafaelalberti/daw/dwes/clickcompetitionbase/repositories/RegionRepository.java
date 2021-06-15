package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Localidad;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RegionRepository extends CrudRepository<Region, Long> {

//    Region findRegionByName(String name);

    @Query("select new Region (r.id, r.name, sum(pl.clicks)) from Region r"  +
            " join Localidad l on r.id = l.region.id " +
            " join Player pl on l.id = pl.localidad.id " +
            " group by r.id ORDER BY sum(pl.clicks) desc  ")

    public ArrayList<Region> regionListOrder();
}
