package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Pais pais;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    Set<Localidad> localidad = new HashSet<>();

    private Long clicks;
    private String name;

    public Region() {}


    public  Region(Long id, String name, Long clicks) {

        this.id = id;
        this.name = name;
        this.clicks = clicks;

    }
    public  Region(String name, Pais pais) {

        this.name = name;
        this.pais = pais;

    }
}
