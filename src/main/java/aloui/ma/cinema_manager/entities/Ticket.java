package aloui.ma.cinema_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private Double prix;
    @Column(unique = true)
    private Integer codePayement;
    private boolean reserver;
    @ManyToOne
    private Place place;
    @ManyToOne
    private FilmProjection projection;
}
