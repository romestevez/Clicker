package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity

public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "equipos", cascade = CascadeType.REMOVE)
    Set<Player> players = new HashSet<>();

    public Equipo() {}

    public Equipo(String name) {

        this.name = name;
    }
    public Equipo(Long id, String name) {

        this.id = id;
        this.name = name;
    }

}
