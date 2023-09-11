package aloui.ma.cinema_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Double duree;
    private String realisateur;
    private String description;
    private String photo;
    @OneToMany(mappedBy = "film")
    private Collection<FilmProjection> projections;
    @ManyToOne
    private Categorie categorie;
}
