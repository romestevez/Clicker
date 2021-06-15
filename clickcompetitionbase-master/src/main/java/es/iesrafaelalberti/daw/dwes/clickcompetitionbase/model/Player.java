package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


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

    public void addClicks(int clicks) {
        this.clicks += clicks;
    }
}
