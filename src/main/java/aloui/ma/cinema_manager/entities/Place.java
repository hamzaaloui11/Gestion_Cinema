package aloui.ma.cinema_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numPlace;
    private Double longitude,latitude,altitude;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "place")
    private Collection<Ticket> tickets;

}
