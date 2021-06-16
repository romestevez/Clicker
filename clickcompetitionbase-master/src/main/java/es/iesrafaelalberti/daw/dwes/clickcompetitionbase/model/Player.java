package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "players_equipo",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "equipo_id"))
    Set<Equipo> equipos = new HashSet<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Localidad localidad;

    private String name;
    private int clicks;

    public Player() {
    }

    public Player(String name, int clicks, Localidad localidad) {
        this.name = name;
        this.clicks = clicks;
        this.localidad = localidad;

    }

    public Player(String name, int clicks, Localidad localidad, Set<Equipo> equipos) {
        this.name = name;
        this.clicks = clicks;
        this.localidad = localidad;
        this.equipos = equipos;


    }

    public void addClicks(int clicks) {
        this.clicks += clicks;
    }
}
