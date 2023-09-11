package aloui.ma.cinema_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String name;
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;
}
