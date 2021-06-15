package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long clicks;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    Set<Region> region = new HashSet<>();

    public Pais() {}

    public Pais(String name) {

        this.name = name;
    }
    public Pais(Long id, String name, Long clicks) {

        this.id = id;
        this.name = name;
        this.clicks = clicks;
    }

}
