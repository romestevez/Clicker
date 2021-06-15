package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@Entity
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Region region;

    @OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL)
    Set<Player> player = new HashSet<>();



    private String name;
    private Long clicks;


    public Localidad() {}

    public Localidad(String name) {
        this.name = name;
    }

    public  Localidad(Long id, String name, Long clicks) {

        this.id = id;
        this.name = name;
        this.clicks = clicks;


    }

    public  Localidad(String name, Region region) {

        this.name = name;
        this.region = region;


    }


}
