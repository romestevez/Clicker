package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.bootstrap;

import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Localidad;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Pais;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Player;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model.Region;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.LocalidadRepository;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.PaisRepository;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.PlayerRepository;
import es.iesrafaelalberti.daw.dwes.clickcompetitionbase.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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


    @Override
    public void run(String... args) throws Exception {

        Pais p1 = paisRepository.save(new Pais("España"));
        Pais p2 = paisRepository.save(new Pais("Españita"));

        Region r1 = regionRepository.save(new Region("Andalucia", p1));
        Region r2 = regionRepository.save(new Region("Anda", p2));

        Localidad l1 = localidadRepository.save(new Localidad("isla cristina", r1));
        Localidad l2 = localidadRepository.save(new Localidad("cristina", r2));



        playerRepository.save(new Player("prueba1", 0, l1));
        playerRepository.save(new Player("prueba2", 10, l2));
        playerRepository.save(new Player("prueba3", 22, l1));
        playerRepository.save(new Player("prueba4", 7, l2));
        playerRepository.save(new Player("prueba5", 13, l1));
        playerRepository.save(new Player("prueba6", 2, l1));
    }
}
