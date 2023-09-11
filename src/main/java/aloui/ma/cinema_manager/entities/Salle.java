package aloui.ma.cinema_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer nbrPlace;
    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy = "salle")
    private Collection<Place>places;
    @OneToMany(mappedBy = "salle")
    private Collection<FilmProjection> projections;
}
