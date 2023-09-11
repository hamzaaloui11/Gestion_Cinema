package aloui.ma.cinema_manager.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double longitude,latitude,altitude;
    private Integer nbrSalle;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
}
