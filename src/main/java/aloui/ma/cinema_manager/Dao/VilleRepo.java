package aloui.ma.cinema_manager.Dao;

import aloui.ma.cinema_manager.entities.Cinema;
import aloui.ma.cinema_manager.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VilleRepo extends JpaRepository<Ville,Long> {
}
