package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.bootstrap;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.*;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EquipoRepository equipoRepository;


    @Override
    public void run(String... args) throws Exception {

        Equipo e1 = equipoRepository.save(new Equipo(("Madrid")));
        Equipo e2 = equipoRepository.save(new Equipo(("Barcelona")));

        Pais p1 = paisRepository.save(new Pais("España"));
        Pais p2 = paisRepository.save(new Pais("Españita"));

        Region r1 = regionRepository.save(new Region("Andalucia", p1));
        Region r2 = regionRepository.save(new Region("Anda", p2));

        Localidad l1 = localidadRepository.save(new Localidad("isla cristina", r1));
        Localidad l2 = localidadRepository.save(new Localidad("cristina", r2));



        playerRepository.save(new Player("prueba1", 0, l1, Set.of(e2)));
        playerRepository.save(new Player("prueba2", 10, l2, Set.of(e1)));
        playerRepository.save(new Player("prueba3", 22, l1, Set.of(e1, e2)));
        playerRepository.save(new Player("prueba4", 7, l2, Set.of(e1,e2)));
        playerRepository.save(new Player("prueba5", 13, l1, Set.of(e2)));
        playerRepository.save(new Player("prueba6", 2, l1, Set.of(e1,e2)));
    }
}
